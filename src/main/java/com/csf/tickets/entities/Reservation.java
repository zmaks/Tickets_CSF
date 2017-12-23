package com.csf.tickets.entities;

import com.csf.tickets.dto.ReservationDto;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Reservation extends BaseEntity {
    private String ticketId;
    private String userId;
    private Date reserveTime;
    private String status;

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
}
