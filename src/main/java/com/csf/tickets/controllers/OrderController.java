package com.csf.tickets.controllers;

import com.csf.tickets.dto.RequestOrderDTO;
import com.csf.tickets.dto.TicketOrderDto;
import com.csf.tickets.dto.UpdateOrderDTO;
import com.csf.tickets.exceptions.ReservationException;
import com.csf.tickets.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    @ResponseBody
    public ResponseEntity<?> createOrder(@RequestBody RequestOrderDTO requestOrderDTO) {
        try {
            orderService.createOrder(requestOrderDTO.getReservationIds(), requestOrderDTO.getUserId(), requestOrderDTO.getOrderType());
        } catch (ReservationException ex) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateOrder(UpdateOrderDTO updateOrderDTO) {
        try {
            orderService.updateOrder(updateOrderDTO.getOrderId(), updateOrderDTO.getOrderStatus());
        } catch (ReservationException ex) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseBody
    public List<TicketOrderDto> getOrders() {
        return orderService.getOrders();
    }
}
