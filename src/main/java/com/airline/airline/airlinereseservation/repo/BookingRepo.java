package com.airline.airline.airlinereseservation.repo;

import com.airline.airline.airlinereseservation.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {


}
