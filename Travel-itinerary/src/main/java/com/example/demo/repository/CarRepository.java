package com.example.demo.repository;

// import com.example.demo.model.BaseLocation;
import com.example.demo.model.Car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.*;

public interface CarRepository extends JpaRepository<Car, Long> {

    // @Query("SELECT c FROM Car c WHERE c.id NOT IN (" +
    // "SELECT bt.vehicle_id FROM BookingTransport bt " +
    // "WHERE bt.vehicleType = 'car' AND (:userEndDate < bt.startDate OR :userStartDate > bt.endDate)) "+
    // "AND c.location = :baseloc")
    // @Query("SELECT b FROM Car b WHERE b.id NOT IN (" +
    // "SELECT bt.vehicleId FROM BookingTransport bt " +
    // "WHERE bt.vehicleType = 'car' AND (:userEndDate < bt.startDate OR :userStartDate > bt.endDate)) "+
    // "AND b.location = :baseloc")
    @Query("SELECT b FROM Car b WHERE b.baseLocation = :baseloc")
    List<Car> findCarsByBaseLocation(String baseloc);
}
