package com.example.demo.services;

import java.util.List;

import com.example.demo.model.HotelRoomInventory;

public interface HotelRoomInventoryService {
    List<HotelRoomInventory> getAllRoomDetails();
    List<HotelRoomInventory> getDetailsByHotelId(Long hotelId);
    HotelRoomInventory saveRoomDetails(HotelRoomInventory roomDetails);
    HotelRoomInventory getRoomTypeDetails(List<HotelRoomInventory> roomDetails, Long roomTypeId);
}
