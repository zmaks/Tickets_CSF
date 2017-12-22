package com.csf.tickets.services.impl;

import com.csf.tickets.entities.Order;
import com.csf.tickets.entities.Reservation;
import com.csf.tickets.repositories.OrderRepository;
import com.csf.tickets.repositories.ReservationRepository;
import com.csf.tickets.services.OrderService;
import com.csf.tickets.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Order createOrder(List<Long> reservations, String userId, String orderType) {
        Order order = new Order();
        order.setReservations(Collections.singletonList(reservationRepository.findOne(reservations.get(0))));
        order.setCreationDate(new Date());
        order.setStatus("initial");
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order updateOrder(String orderId) {
        return null;
    }
}
