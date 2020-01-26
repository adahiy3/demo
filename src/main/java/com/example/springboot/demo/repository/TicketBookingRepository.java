package com.example.springboot.demo.repository;

import com.example.springboot.demo.entities.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketBookingRepository extends CrudRepository<Ticket, Integer> {
}
