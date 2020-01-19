package com.example.springboot.demo.controller;

import com.example.springboot.demo.entities.Ticket;
import com.example.springboot.demo.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/tickets")
public class TicketBookingController {


    @Autowired
    TicketBookingService ticketBookingService;

    @GetMapping(value = "/allTickets")
    public List<Ticket> getTicketdetails() {

        return ticketBookingService.getTicketDetails();

    }

    @GetMapping(value = "/ticketid")
    public Ticket getTicketdetail(@PathVariable("ticketid") Integer ticketId) {

        Optional<Ticket> ticketOptional = ticketBookingService.getTicketDetail(ticketId);
        return ticketOptional.get();


    }

    @PostMapping(value = "/ticket")
    public Ticket createTicketdetail(@RequestBody Ticket ticket) {
       /* Ticket ticket = new Ticket();
        ticket.setDestinationStation("test");
        ticket.setPassengerName("amit");
        ticket.setStartStation("teststa");
        ticket.setDestinationStation("testdessta");*/
        ticket.setTravelDate(Instant.now());
        ticketBookingService.saveTicketDetails(ticket);
        return ticket;
    }

    @PutMapping(value = "/updateemail/{ticketId}/{newEmailId:.+}")
    public Ticket updateEmailAddress(@PathVariable("ticketId") Integer ticketId, @PathVariable("newEmailId") String newEmailId) {
        Ticket ticket = ticketBookingService.getTicketDetail(ticketId).get();
        ticket.setEmail(newEmailId);
        return ticketBookingService.saveTicketDetails(ticket);
    }
}
