// package com.example.demo.repository;

// import com.example.demo.model.Bus;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// // import com.example.demo.model.BaseLocation;
// import org.springframework.stereotype.Repository;
// import java.time.LocalDate;
// import java.util.*;


// @Repository
// public interface BusRepository extends JpaRepository<Bus, Long> {
    
//     // @Query("SELECT b FROM Bus b WHERE b.id NOT IN (" +
//     // "SELECT bt.vehicle_id FROM BookingTransport bt " +
//     // "WHERE bt.vehicleType = 'bus' AND (:userEndDate < bt.startDate OR :userStartDate > bt.endDate)) "+
//     // "WHERE b.location = :baseloc")
//     // @Query("SELECT b FROM Bus b WHERE b.id NOT IN (" +
//     // "SELECT bt.vehicleId FROM BookingTransport bt " +
//     // "WHERE bt.vehicleType = 'bus' AND (:userEndDate < bt.startDate OR :userStartDate > bt.endDate)) "+
//     // "AND b.location = :baseloc")
//     @Query("SELECT b FROM Bus b WHERE b.baseLocation = :baseloc")
//     List<Bus> findBusesByBaseLocation( String baseloc);
// }
