package com.csf.tickets.services.impl;

import com.csf.tickets.dto.TicketDto;
import com.csf.tickets.services.TicketService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Value("${catalog-url}")
    private String catalogUrl;

    private RestTemplate restTemplate;

    @PostConstruct
    private void init() {
        restTemplate = new RestTemplate();
    }

    @Override
    public Optional<TicketDto> getTicketById(String ticketId) {
        return Optional.of(restTemplate.getForObject(catalogUrl + "/" + ticketId, TicketDto.class));
    }

    @Override
    public void updateTicket(TicketDto ticketDto, String status) {
        ticketDto.setStatus(status);
        restTemplate.put(catalogUrl + "/"+ticketDto.getId(), ticketDto, TicketDto.class);
    }
}
