package com.csf.tickets.controllers;

import com.csf.tickets.dto.ReservationDto;
import com.csf.tickets.entities.Reservation;
import com.csf.tickets.exceptions.ReservationException;
import com.csf.tickets.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reserve/")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/{userId}")
    @ResponseBody
    public List<Reservation> getHomepage(@PathVariable String userId) {
        return reservationService.getReservationsByUserId(userId);
    }

    @PostMapping
    @ResponseBody
    public Reservation reserve(@RequestBody ReservationDto reservationDto) throws ReservationException {
        return reservationService.create(reservationDto);
    }
}
