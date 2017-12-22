package com.csf.tickets.services;


import com.csf.tickets.entities.Reservation;

import java.util.List;

public interface ReservationService {
    void performReservationOrdering(List<Reservation> reservations);

}
