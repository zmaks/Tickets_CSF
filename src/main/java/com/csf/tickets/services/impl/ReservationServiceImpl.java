package com.csf.tickets.services.impl;

import com.csf.tickets.dto.ReservationDto;
import com.csf.tickets.entities.Reservation;
import com.csf.tickets.exceptions.ReservationException;
import com.csf.tickets.services.ReservationService;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {
    @Override
    public void performReservationOrdering(List<Reservation> reservations) throws ReservationException {

    }

    @Override
    public Reservation create(ReservationDto reservation) throws ReservationException {
        return null;
    }

    @Override
    public List<Reservation> getReservationsByUserId(String userId) {
        return null;
    }

    @Override
    public List<Reservation> getOldReservations() {
        return null;
    }

    @Override
    public Reservation cancelReservation(Long reservationId) throws ReservationException {
        return null;
    }
}
