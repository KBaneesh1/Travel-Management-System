package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ACRoom;

@Repository
public interface ACRoomRepository extends JpaRepository<ACRoom, Long>{
    @Query("SELECT ac FROM ACRoom ac WHERE hotelId = :hotelId")
    public ACRoom findByHotelId(@Param("hotelId") Long hotelId);
}
