package com.csf.tickets.exceptions;

/**
 * Created by Maksim on 23.12.2017.
 */
public class ReservationException extends Exception {
    public ReservationException(String message) {
        super(message);
    }

    public ReservationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReservationException(Throwable cause) {
        super(cause);
    }
}
