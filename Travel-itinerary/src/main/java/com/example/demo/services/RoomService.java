package com.example.demo.services;

import java.util.List;

import com.example.demo.model.ACRoom;
import com.example.demo.model.NonACRoom;

public interface RoomService {
    //Optional<Long> findRoomIdByRoomType(String roomType);
    List<ACRoom> getAllACRooms();
    List<NonACRoom> getAllNonACRooms();
    ACRoom saveACRoom(ACRoom acRoom);
    NonACRoom saveNonACRoom(NonACRoom nonACRoom);
    ACRoom getACRoomByHotelId(Long hotelId);
    NonACRoom getNonACRoomByHotelId(Long hotelId);
}

