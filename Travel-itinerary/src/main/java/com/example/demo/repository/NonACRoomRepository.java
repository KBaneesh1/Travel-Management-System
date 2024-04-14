package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.NonACRoom;

@Repository
public interface NonACRoomRepository extends JpaRepository<NonACRoom, Long> {
    @Query("SELECT ac FROM NonACRoom ac WHERE hotelId = :hotelId")
    public NonACRoom findByHotelId(@Param("hotelId") Long hotelId);
}
