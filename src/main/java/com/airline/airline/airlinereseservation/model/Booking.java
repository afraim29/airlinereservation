package com.airline.airline.airlinereseservation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "booking_id")
    private Long id;
    private String flightFrom;
    private String flightTo;
    private Date dateOfFlight;

    @Column(name = "passenger_id")
    private Long passengerId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "passenger_id", insertable = false, updatable = false)
    private Passenger passenger;

    public Booking() {
    }

    public Booking(String flightFrom, String flightTo, Date dateOfFlight, Long passengerId, Passenger passenger) {
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
        this.dateOfFlight = dateOfFlight;
        this.passengerId = passengerId;
        this.passenger = passenger;
    }

    public Booking(Long id, String flightFrom, String flightTo, Date dateOfFlight, Long passengerId, Passenger passenger) {
        this.id = id;
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
        this.dateOfFlight = dateOfFlight;
        this.passengerId = passengerId;
        this.passenger = passenger;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(String flightFrom) {
        this.flightFrom = flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(String flightTo) {
        this.flightTo = flightTo;
    }

    public Date getDateOfFlight() {
        return dateOfFlight;
    }

    public void setDateOfFlight(Date dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", flightFrom='" + flightFrom + '\'' +
                ", flightTo='" + flightTo + '\'' +
                ", dateOfFlight=" + dateOfFlight +
                ", passenger=" + passenger +
                '}';
    }
}
