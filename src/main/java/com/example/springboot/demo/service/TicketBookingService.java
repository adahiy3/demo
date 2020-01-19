package com.example.springboot.demo.service;

import com.example.springboot.demo.entities.Ticket;
import com.example.springboot.demo.repository.TicketBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketBookingService {

    @Autowired
    TicketBookingRepository ticketBookingRepository;

    public Ticket saveTicketDetails(Ticket ticket){
       return ticketBookingRepository.save(ticket);


    }
}
