package com.csf.tickets.services;


import com.csf.tickets.dto.ReservationDto;
import com.csf.tickets.entities.Reservation;
import com.csf.tickets.exceptions.ReservationException;

import java.util.List;

public interface ReservationService {
    void performReservationOrdering(List<Reservation> reservations) throws ReservationException;

    void performReservationComplited(List<Reservation> reservations) throws ReservationException;

    Reservation create(ReservationDto reservation) throws ReservationException;

    List<Reservation> getReservationsByUserId(String userId);

    List<Reservation> getOldReservations();

    Reservation getReservationsById(Long id);

    Reservation cancelReservation(Long reservationId) throws ReservationException;

}
