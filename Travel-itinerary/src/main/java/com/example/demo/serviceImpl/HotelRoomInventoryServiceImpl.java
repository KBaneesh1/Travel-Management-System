package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.HotelRoomInventory;
import com.example.demo.repository.HotelRoomInventoryRepository;
import com.example.demo.services.HotelRoomInventoryService;

@Service
public class HotelRoomInventoryServiceImpl implements HotelRoomInventoryService{
    
    private HotelRoomInventoryRepository hotelRoomInventoryRepository;

    private RoomTypeServiceImpl roomTypeServiceImpl;
    
    public HotelRoomInventoryServiceImpl(HotelRoomInventoryRepository hotelRoomInventoryRepository){
        super();
        this.hotelRoomInventoryRepository = hotelRoomInventoryRepository;
    }

    public List<HotelRoomInventory> getAllRoomDetails(){
        return hotelRoomInventoryRepository.findAll();
    }

    public List<HotelRoomInventory> getDetailsByHotelId(Long hotelId){
        return hotelRoomInventoryRepository.findDetailsByHotelId(hotelId);
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

    public HotelRoomInventory getRoomTypeDetails(List<HotelRoomInventory> roomDetails, Long roomTypeId){
        for(HotelRoomInventory hri:roomDetails){
            if (hri.getRoomTypeId().equals(roomTypeId)){
                return hri;
            }
        }

        return null;
    }
}

//for each hotel, get its details and room details into a single object