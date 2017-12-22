package com.csf.tickets.services.impl;

import com.csf.tickets.dto.ReservationDto;
import com.csf.tickets.entities.Reservation;
import com.csf.tickets.services.ReservationService;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {
    @Override
    public void performReservationOrdering(List<Reservation> reservations) {

    }

    @Override
    public Reservation create(ReservationDto reservation) {
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
}
