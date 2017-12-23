package com.csf.tickets.services.impl;

import com.csf.tickets.dto.TicketDto;
import com.csf.tickets.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return Optional.of(restTemplate.getForObject(catalogUrl, TicketDto.class));
    }

    @Override
    public void updateTicket(TicketDto ticketDto, String status) {
        ticketDto.setStatus(status);
        restTemplate.patchForObject(catalogUrl, ticketDto, TicketDto.class);
    }
}
