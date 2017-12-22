package com.csf.tickets.services;

import com.csf.tickets.dto.OrderDTO;
import com.csf.tickets.entities.Order;
import com.csf.tickets.entities.Reservation;

import java.util.List;

public interface OrderService {
    Order createOrder(List<Long> reservations, String userId, String orderType);

    Order updateOrder(String orderId);
}
