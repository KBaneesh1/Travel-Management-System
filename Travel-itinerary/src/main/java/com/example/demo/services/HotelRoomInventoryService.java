package com.example.demo.services;

import java.util.List;

import com.example.demo.model.HotelRoomInventory;

public interface HotelRoomInventoryService {
    List<HotelRoomInventory> getAllRoomDetails();
    HotelRoomInventory saveRoomDetails(HotelRoomInventory roomDetails);
}
