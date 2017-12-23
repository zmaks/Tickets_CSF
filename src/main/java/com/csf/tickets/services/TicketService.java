package com.csf.tickets.services;

import com.csf.tickets.dto.TicketDto;

import java.util.Optional;

public interface TicketService {
    Optional<TicketDto> getTicketById(String ticketId);
    void updateTicket(TicketDto ticketDto, String status);
}
