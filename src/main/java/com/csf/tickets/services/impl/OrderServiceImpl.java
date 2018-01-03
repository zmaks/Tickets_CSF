package com.csf.tickets.services.impl;

import com.csf.tickets.constants.OrderStatus;
import com.csf.tickets.dto.TicketOrderDto;
import com.csf.tickets.entities.TicketOrder;
import com.csf.tickets.entities.Reservation;
import com.csf.tickets.exceptions.ReservationException;
import com.csf.tickets.repositories.OrderRepository;
import com.csf.tickets.repositories.ReservationRepository;
import com.csf.tickets.services.OrderService;
import com.csf.tickets.services.ReservationService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationService reservationService;

    @Override
    public TicketOrder createOrder(List<Long> reservations, String userId, String orderType) throws ReservationException {
        TicketOrder order = new TicketOrder();
        List<Reservation> reservationList = reservationRepository.findByIdIn(reservations);
        order.setReservations(reservationList);
        order.setCreationDate(new Date());
        order.setStatus(OrderStatus.IN_PROGRESS.getName());
        for(Reservation reservation:reservationList){
            reservation.setOrder(order);
        }

        orderRepository.save(order);
        reservationService.performReservationOrdering(reservationList);
        return order;
    }

    @Override
    public TicketOrder updateOrder(Long orderId, OrderStatus status) throws ReservationException {
        TicketOrder order = orderRepository.findOne(orderId);
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
    public List<TicketOrder> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public TicketOrder getOrdersById(Long orderId) {
        return orderRepository.findOne(orderId);
    }

    @Override
    public List<TicketOrderDto> getOrders() {
        List<TicketOrderDto> ticketDtos = new ArrayList<>();
        for(TicketOrder ticketOrder: Lists.newArrayList(orderRepository.findAll())){
            TicketOrderDto ticketDto = new TicketOrderDto();
            ticketDto.setId(ticketOrder.getTicketOrderId().toString());
            ticketDto.setStatus(ticketOrder.getStatus());
            ticketDto.setCreationDate(ticketOrder.getCreationDate());
            ticketDto.setReservations(ticketOrder.getReservations().stream().map(Reservation::getId).collect(Collectors.toList()));
            ticketDtos.add(ticketDto);
        }
        return ticketDtos;
    }

}
