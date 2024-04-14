package com.example.demo.repository;

import com.example.demo.model.BaseLocation;
import com.example.demo.model.Car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.*;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c WHERE c.id NOT IN (" +
    "SELECT bt.vehicle.id FROM BookingTransport bt " +
    "WHERE bt.vehicleType = 'car' AND (:userEndDate < bt.start OR :userStartDate > bt.end)) "+
    "AND c.location = :baseloc.name")
    List<Car> findAvailableCars(LocalDate userStartDate, LocalDate userEndDate,BaseLocation baseloc);
}
