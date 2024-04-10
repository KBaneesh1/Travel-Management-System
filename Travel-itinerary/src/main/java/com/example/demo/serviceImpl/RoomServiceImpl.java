package com.example.demo.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.ACRoomRepository;
import com.example.demo.repository.NonACRoomRepository;
import com.example.demo.services.RoomService;
import com.example.demo.model.ACRoom;
import com.example.demo.model.NonACRoom;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    private ACRoomRepository acRoomRepository;
    private NonACRoomRepository nonacRoomRepository;

    public RoomServiceImpl(ACRoomRepository acRoomRepository, NonACRoomRepository nonacRoomRepository){
        super();
        this.acRoomRepository = acRoomRepository;
        this.nonacRoomRepository = nonacRoomRepository;
    }
    public List<ACRoom> getAllACRooms(){
        return acRoomRepository.findAll();
    }
    public List<NonACRoom> getAllNonACRooms(){
        return nonacRoomRepository.findAll();
    }

    public ACRoom saveACRoom(ACRoom acRoom){
        return acRoomRepository.save(acRoom);
    }

    public NonACRoom saveNonACRoom(NonACRoom nonACRoom){
        return nonacRoomRepository.save(nonACRoom);
    }

    public ACRoom getACRoomByHotelId(Long hotelId){
        return  acRoomRepository.findByHotelId(hotelId);
    }

    public NonACRoom getNonACRoomByHotelId(Long hotelId){
        return  nonacRoomRepository.findByHotelId(hotelId);
    }

}
