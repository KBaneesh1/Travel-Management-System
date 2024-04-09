package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.HotelRoomInventory;
import com.example.demo.repository.HotelRoomInventoryRepository;
import com.example.demo.services.HotelRoomInventoryService;

@Service
public class HotelRoomInventoryServiceImpl implements HotelRoomInventoryService{
    
    private HotelRoomInventoryRepository hotelRoomInventoryRepository;
    
    public HotelRoomInventoryServiceImpl(HotelRoomInventoryRepository hotelRoomInventoryRepository){
        super();
        this.hotelRoomInventoryRepository = hotelRoomInventoryRepository;
    }

    public List<HotelRoomInventory> getAllRoomDetails(){
        return hotelRoomInventoryRepository.findAll();
    }

    public HotelRoomInventory saveRoomDetails(HotelRoomInventory roomDetails){
        HotelRoomInventory res;
        if (roomDetails.getNumberOfRooms() > 0){
            res = hotelRoomInventoryRepository.save(roomDetails);
        } else {
            res =  null;
        }
        return res;
    }
}
