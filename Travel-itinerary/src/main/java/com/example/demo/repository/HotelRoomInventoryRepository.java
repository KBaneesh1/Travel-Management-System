package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.HotelRoomInventory;

@Repository
public interface HotelRoomInventoryRepository extends JpaRepository<HotelRoomInventory, Long>{

}
