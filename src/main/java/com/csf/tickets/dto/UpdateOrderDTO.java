package com.csf.tickets.dto;

import com.csf.tickets.constants.OrderStatus;

import java.util.List;


public class UpdateOrderDTO {
    Long orderId;

    OrderStatus orderStatus;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

}
