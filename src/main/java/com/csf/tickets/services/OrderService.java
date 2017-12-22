package com.csf.tickets.services;

import com.csf.tickets.entities.Order;
import com.csf.tickets.entities.Reservation;

import java.util.List;

public interface OrderService {
    Order createOrder(List<Reservation> reservations, String userId);
}
