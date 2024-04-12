package com.example.demo.repository;

import com.example.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT b FROM Bus b WHERE b.id NOT IN (" +
    "SELECT bt.vehicle.id FROM BookingTransport bt " +
    "WHERE bt.vehicleType = 'car' AND :userStartDate <= bt.end AND :userEndDate >= bt.start)")
    List<Car> findAvailableCars(Date userStartDate, Date userEndDate);
}