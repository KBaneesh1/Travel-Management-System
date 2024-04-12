package com.example.demo.repository;

import com.example.demo.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;


public interface BusRepository extends JpaRepository<Bus, Long> {
    @Query("SELECT b FROM Bus b WHERE b.id NOT IN (" +
    "SELECT bt.vehicle.id FROM BookingTransport bt " +
    "WHERE bt.vehicleType = 'bus' AND :userStartDate <= bt.end AND :userEndDate >= bt.start)")
    List<Bus> findAvailableBuses(Date userStartDate, Date userEndDate);
}
