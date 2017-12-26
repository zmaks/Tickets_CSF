package com.csf.tickets.services.impl;

import com.csf.tickets.constants.OrderStatus;
import com.csf.tickets.dto.OrderDTO;
import com.csf.tickets.dto.TicketDto;
import com.csf.tickets.entities.Order;
import com.csf.tickets.entities.Reservation;
import com.csf.tickets.exceptions.ReservationException;
import com.csf.tickets.repositories.OrderRepository;
import com.csf.tickets.repositories.ReservationRepository;
import com.csf.tickets.services.OrderService;
import com.csf.tickets.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationService reservationService;

    @Override
    public Order createOrder(List<Long> reservations, String userId, String orderType) throws ReservationException {
        Order order = new Order();
        List<Reservation> reservationList = reservationRepository.findByIdIn(reservations);
        order.setReservations(reservationList);
        order.setCreationDate(new Date());
        order.setStatus(OrderStatus.IN_PROGRESS.getName());
        reservationService.performReservationOrdering(reservationList);
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order updateOrder(Long orderId, OrderStatus status) throws ReservationException {
        Order order = orderRepository.findOne(orderId);
        order.setStatus(status.getName());
        orderRepository.save(order);
        switch (status) {
            case CANCELED:
                for (Reservation res : order.getReservations()) {
                    reservationService.cancelReservation(res.getId());
                }
                break;
            case COMPLITED:
                reservationService.performReservationComplited(order.getReservations());
                break;
        }
        return order;
    }

    @Override
    public List<Order> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Order getOrdersById(Long orderId) {
        return orderRepository.findOne(orderId);
    }

}
