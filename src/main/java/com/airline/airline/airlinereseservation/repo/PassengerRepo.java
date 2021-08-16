package com.airline.airline.airlinereseservation.repo;

import com.airline.airline.airlinereseservation.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Long> {

    public Passenger findPassengerByUsername(String username);
}
