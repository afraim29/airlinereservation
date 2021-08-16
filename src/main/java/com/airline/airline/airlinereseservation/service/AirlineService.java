package com.airline.airline.airlinereseservation.service;

import com.airline.airline.airlinereseservation.exception.UserNotFoundException;
import com.airline.airline.airlinereseservation.model.Booking;
import com.airline.airline.airlinereseservation.model.Passenger;
import com.airline.airline.airlinereseservation.pojos.BookingRequest;
import com.airline.airline.airlinereseservation.repo.BookingRepo;
import com.airline.airline.airlinereseservation.repo.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineService {

    private final PassengerRepo passengerRepo;
    private final BookingRepo bookingRepo;

    @Autowired
    public AirlineService(PassengerRepo passengerRepo, BookingRepo bookingRepo) {
        this.passengerRepo = passengerRepo;
        this.bookingRepo = bookingRepo;
    }

    public List<Passenger> getAllPassenger() {
        return passengerRepo.findAll();
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepo.findById(id).orElseThrow(()-> new UserNotFoundException("Passenger " + id + " does not exists."));
    }

    public Passenger addPassenger(Passenger passenger) {
        return passengerRepo.save(passenger);
    }

    public Passenger updatePassenger(Passenger passenger) {
        return passengerRepo.save(passenger);
    }

    public void deletePassenger(Long id) {
        passengerRepo.deleteById(id);
    }

    public Booking addBooking(BookingRequest bookingRequest) {
        Booking booking = new Booking();
        booking.setFlightFrom(bookingRequest.flightFrom);
        booking.setFlightTo(bookingRequest.flightTo);
        booking.setDateOfFlight(bookingRequest.dateOfFlight);
        booking.setPassengerId(bookingRequest.passengerId);
        System.out.println(bookingRequest.passengerId);
        System.out.println(booking);
        return bookingRepo.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingRepo.deleteById(id);
    }
}
