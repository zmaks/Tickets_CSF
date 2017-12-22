package com.csf.tickets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reserve")
public class ReservationController {
    @GetMapping
    public String getHomepage(@PathVariable String userId) {
        // TODO: 22.12.2017 add
        return "hi";
    }
}
