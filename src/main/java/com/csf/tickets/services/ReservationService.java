package com.csf.tickets.services;


import com.csf.tickets.dto.ReservationDto;
import com.csf.tickets.entities.Reservation;

import java.util.List;

public interface ReservationService {
    void performReservationOrdering(List<Reservation> reservations);

    Reservation create(ReservationDto reservation);

    List<Reservation> getReservationsByUserId(String userId);

    List<Reservation> getOldReservations();
}
