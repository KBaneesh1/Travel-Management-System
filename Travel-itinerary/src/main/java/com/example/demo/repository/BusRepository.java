package com.example.demo.repository;

import com.example.demo.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.model.BaseLocation;
import java.time.LocalDate;
import java.util.*;


public interface BusRepository extends JpaRepository<Bus, Long> {
    
    @Query("SELECT b FROM Bus b WHERE b.id NOT IN (" +
    "SELECT bt.vehicle.id FROM BookingTransport bt " +
    "WHERE bt.vehicleType = 'bus' AND (:userEndDate < bt.start OR :userStartDate > bt.end)) "+
    "WHERE b.location = :baseloc.name")
    List<Bus> findAvailableBuses(LocalDate userStartDate, LocalDate userEndDate , BaseLocation baseloc);
}
