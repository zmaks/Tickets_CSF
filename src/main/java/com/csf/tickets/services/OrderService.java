package com.csf.tickets.services;

import com.csf.tickets.constants.OrderStatus;
import com.csf.tickets.dto.TicketDto;
import com.csf.tickets.dto.TicketOrderDto;
import com.csf.tickets.entities.TicketOrder;
import com.csf.tickets.exceptions.ReservationException;

import java.util.List;

public interface OrderService {
    TicketOrder createOrder(List<Long> reservations, String userId, String orderType) throws ReservationException;

    TicketOrder updateOrder(Long orderId, OrderStatus status)  throws ReservationException;

    List<TicketOrder> getOrdersByUserId(String userId);

    TicketOrder getOrdersById(Long orderId);

    List<TicketOrderDto> getOrders();

}
