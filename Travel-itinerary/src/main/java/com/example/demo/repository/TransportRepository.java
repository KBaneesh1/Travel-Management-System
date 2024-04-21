package com.example.demo.repository;

// import com.example.demo.model.BaseLocation;
import com.example.demo.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Long> {

    // @Query("SELECT c FROM Car c WHERE c.id NOT IN (" +
    // "SELECT bt.vehicle_id FROM BookingTransport bt " +
    // "WHERE bt.vehicleType = 'car' AND (:userEndDate < bt.startDate OR :userStartDate > bt.endDate)) "+
    // "AND c.location = :baseloc")
    // @Query("SELECT b FROM Car b WHERE b.id NOT IN (" +
    // "SELECT bt.vehicleId FROM BookingTransport bt " +
    // "WHERE bt.vehicleType = 'car' AND (:userEndDate < bt.startDate OR :userStartDate > bt.endDate)) "+
    // "AND b.location = :baseloc")
    @Query("SELECT b FROM Transport b WHERE b.baseLocation = :baseloc")
    List<Transport> findTransportByBaseLocation(@Param("baseloc") String baseloc);
}
