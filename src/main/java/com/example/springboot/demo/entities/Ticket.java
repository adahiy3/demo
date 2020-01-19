package com.example.springboot.demo.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id")
    Integer id;

    @Column(name = "passenger_name")
    String passengerName;

    @Column(name = "ticket_price")
    Integer ticketPrice;

    @Column(name = "start_station")
    String startStation;

    @Column(name = "destination_station")
    String destinationStation;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "travel_date")
    Instant travelDate;

    @Column(name="passenger_email")
    String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    public Instant getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Instant travelDate) {
        this.travelDate = travelDate;
    }
}
