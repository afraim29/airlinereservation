package com.airline.airline.airlinereseservation.controller;

import com.airline.airline.airlinereseservation.model.Booking;
import com.airline.airline.airlinereseservation.model.Passenger;
import com.airline.airline.airlinereseservation.pojos.BookingRequest;
import com.airline.airline.airlinereseservation.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AirlineController {

    private final AirlineService airlineService;

    @Autowired
    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping("/api/v1/passengers")
    public ResponseEntity<List<Passenger>> getAllPassenger(){
        List<Passenger> allPassenger = airlineService.getAllPassenger();
        return new ResponseEntity<>(allPassenger, HttpStatus.OK);
    }

    @GetMapping("api/v1/passenger/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable("id") Long id){
        Passenger onePassenger = airlineService.getPassengerById(id);
        return new ResponseEntity<>(onePassenger, HttpStatus.OK);
    }

    @PostMapping("api/v1/passenger/add")
    public ResponseEntity<Passenger> addPassenger(@RequestBody Passenger passenger){
        Passenger addPassenger = airlineService.addPassenger(passenger);
        return new ResponseEntity<>(addPassenger, HttpStatus.CREATED);
    }

    @PutMapping("api/v1/passenger/update")
    public ResponseEntity<Passenger> updatePassenger(@RequestBody Passenger passenger){
        Passenger updatePassenger = airlineService.updatePassenger(passenger);
        return new ResponseEntity<>(updatePassenger, HttpStatus.OK);
    }

    @DeleteMapping("api/v1/passengers/delete/{id}")
    public ResponseEntity<?> updatePassenger(@PathVariable Long id){
        airlineService.deletePassenger(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("api/v1/booking/add")
    public ResponseEntity<?> addBooking(@RequestBody BookingRequest bookingRequest){
        Booking newBooking = airlineService.addBooking(bookingRequest);
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/v1/booking/delete/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable("id") Long id){
        airlineService.deleteBooking(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
