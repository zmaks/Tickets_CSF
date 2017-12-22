package com.csf.tickets.controllers;

import com.csf.tickets.dto.RequestOrderDTO;
import com.csf.tickets.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createOrder(RequestOrderDTO requestOrderDTO) {
        orderService.createOrder(requestOrderDTO.getReservationIds(), requestOrderDTO.getUserId(), requestOrderDTO.getOrderType());
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

}
