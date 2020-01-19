package com.example.springboot.demo.controller;

import com.example.springboot.demo.entities.Ticket;
import com.example.springboot.demo.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
public class TicketBookingController {


    @Autowired
    TicketBookingService ticketBookingService;

    @GetMapping(value = "/ticketid")
    public List<Ticket> getTicketdetails(){

        return ticketBookingService.getTicketDetails();

    }

    @PostMapping(value = "/ticket")
    public Ticket createTicketdetail(){
         Ticket ticket =new Ticket();
         ticket.setDestinationStation("test");
         ticket.setPassengerName("amit");
         ticket.setStartStation("teststa");
         ticket.setDestinationStation("testdessta");
         ticket.setTravelDate(Instant.now());

        ticketBookingService.saveTicketDetails(ticket);

         return ticket;

    }
}
