package com.csf.tickets.services.impl;

import com.csf.tickets.constants.ReservationStatus;
import com.csf.tickets.constants.TicketStatus;
import com.csf.tickets.dto.ReservationDto;
import com.csf.tickets.dto.TicketDto;
import com.csf.tickets.entities.Reservation;
import com.csf.tickets.exceptions.ReservationException;
import com.csf.tickets.repositories.ReservationRepository;
import com.csf.tickets.services.ReservationService;
import com.csf.tickets.services.TicketService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private TicketService ticketService;

    @Override
    public void performReservationOrdering(List<Reservation> reservations) throws ReservationException {
        for (Reservation reservation : reservations) {
            reservation.setStatus(ReservationStatus.IN_PROGRESS);
            reservationRepository.save(reservation);
            Optional<TicketDto> ticketDto = ticketService.getTicketById(reservation.getTicketId());
            if (!ticketDto.isPresent()) {
                throw new ReservationException("Ticket not found");
            }
            ticketDto.ifPresent(x -> ticketService.updateTicket(x, TicketStatus.ORDERED));
        }
    }

    @Override
    @Transactional
    public Reservation create(ReservationDto reservation) throws ReservationException {
        checkReservationRequest(reservation);

        Optional<TicketDto> ticketDto = ticketService.getTicketById(reservation.getTicketId());
        if (!ticketDto.isPresent()) throw new ReservationException("Ticket not found");
        ticketDto.ifPresent(t -> ticketService.updateTicket(t, TicketStatus.RESERVED));

        Reservation reservationEntity = new Reservation(reservation);
        reservation.setStatus(ReservationStatus.WAITING);
        reservation.setReserveTime(new Date());
        reservationEntity = reservationRepository.save(reservationEntity);

        return reservationEntity;
    }

    @Override
    public List<Reservation> getReservationsByUserId(String userId) {
        return reservationRepository.findByUserId(userId);
    }

    @Override
    public List<Reservation> getOldReservations() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -1);
        return reservationRepository.findByReserveTimeBeforeAndStatus(calendar.getTime(), ReservationStatus.WAITING);
    }

    @Override
    public Reservation cancelReservation(Long reservationId) throws ReservationException {
        Reservation reservation = reservationRepository.findOne(reservationId);
        reservation.setStatus(ReservationStatus.CANCELED);
        reservationRepository.save(reservation);
        Optional<TicketDto> ticketDto = ticketService.getTicketById(reservation.getTicketId());
        if(!ticketDto.isPresent()) throw new ReservationException("Ticket not found");
        ticketDto.ifPresent(t -> ticketService.updateTicket(t, TicketStatus.FREE));
        return null;
    }

    private void checkReservationRequest(ReservationDto reservation) throws ReservationException {
        if (reservation == null) throw new ReservationException("Passed dto is null");
        if (reservation.getTicketId() == null) throw new ReservationException("Ticket ID is null");
        if (reservation.getUserId() == null) throw new ReservationException("User ID is null");
    }
}
