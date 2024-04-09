package com.example.demo.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.RoomTypeRepository;
import com.example.demo.services.RoomTypeService;

import java.util.Optional;

@Service
@Transactional
public class RoomTypeServiceImpl implements RoomTypeService{

    private final RoomTypeRepository roomTypeRepository;

    @Autowired
    public RoomTypeServiceImpl(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    @Override
    public Optional<Long> findRoomIdByRoomType(String roomType) {
        return roomTypeRepository.findRoomIdByRoomType(roomType);
    }
}
