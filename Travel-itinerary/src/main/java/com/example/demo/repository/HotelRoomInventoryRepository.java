package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.HotelRoomInventory;

@Repository
public interface HotelRoomInventoryRepository extends JpaRepository<HotelRoomInventory, Long>{
    @Query("SELECT hri FROM HotelRoomInventory hri WHERE hri.hotelId = ?1")
    public List<HotelRoomInventory> findDetailsByHotelId(Long hotelId);
}
