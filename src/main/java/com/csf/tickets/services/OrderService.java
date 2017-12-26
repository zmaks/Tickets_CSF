package com.csf.tickets.services;

import com.csf.tickets.constants.OrderStatus;
import com.csf.tickets.dto.OrderDTO;
import com.csf.tickets.entities.Order;
import com.csf.tickets.exceptions.ReservationException;

import java.util.List;

public interface OrderService {
    Order createOrder(List<Long> reservations, String userId, String orderType) throws ReservationException;

    Order updateOrder(Long orderId, OrderStatus status)  throws ReservationException;

    List<Order> getOrdersByUserId(String userId);

    Order getOrdersById(Long orderId);

}
