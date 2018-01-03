package com.csf.tickets.entities;

import com.csf.tickets.dto.ReservationDto;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String ticketId;
    private String userId;
    private Date reserveTime;
    private String status;

    @ManyToOne
    @JoinColumn(name="ticketOrderId")
    private TicketOrder order;

    public Reservation() {
    }

    public Reservation(ReservationDto reservationDto) {
        this(reservationDto.getTicketId(), reservationDto.getUserId());
    }

    public Reservation(String ticketId, String userId) {
        this.ticketId = ticketId;
        this.userId = userId;
    }



    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(Date reserveTime) {
        this.reserveTime = reserveTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TicketOrder getOrder() {
        return order;
    }

    public void setOrder(TicketOrder order) {
        this.order = order;
    }
}
