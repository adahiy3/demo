package com.example.springboot.demo.service;

import com.example.springboot.demo.entities.Ticket;
import com.example.springboot.demo.repository.TicketBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketBookingService {

    @Autowired
    TicketBookingRepository ticketBookingRepository;

    public Ticket saveTicketDetails(Ticket ticket) {
        return ticketBookingRepository.save(ticket);
    }


    public List<Ticket> getTicketDetails() {
        return (List<Ticket>) ticketBookingRepository.findAll();
    }

    public Optional<Ticket> getTicketDetail(Integer ticketId) {
        return ticketBookingRepository.findById(ticketId);
    }
}
