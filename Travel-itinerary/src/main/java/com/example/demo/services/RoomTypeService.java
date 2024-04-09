package com.example.demo.services;
import java.util.Optional;

public interface RoomTypeService {
    Optional<Long> findRoomIdByRoomType(String roomType);
}

