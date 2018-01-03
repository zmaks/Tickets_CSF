package com.csf.tickets.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class TicketOrder {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long ticketOrderId;
    private Date creationDate;

    @OneToMany(mappedBy="order")
    private List<Reservation> reservations;

    private String status;
    private Integer amount;
    private Integer discount;
    private Integer totalAmount;
    private Integer userId;

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getTicketOrderId() {
        return ticketOrderId;
    }

    public void setTicketOrderId(Long ticketOrderId) {
        this.ticketOrderId = ticketOrderId;
    }
}
