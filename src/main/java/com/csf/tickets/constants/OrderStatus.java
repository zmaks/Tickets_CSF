package com.csf.tickets.constants;

public enum OrderStatus {
    IN_PROGRESS("in progress"),
    CANCELED("canceled"),
    COMPLITED("complited");

    OrderStatus(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
