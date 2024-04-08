package com.example.demo.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.demo.repository.HotelRepository;
import com.example.demo.services.HotelService;
import com.example.demo.model.Hotel;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{
    private HotelRepository hotelRepository;
    
    public HotelServiceImpl(HotelRepository hotelRepository) {
        super();
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> getAllHotels(){
        return hotelRepository.findAll();
    }

    @Override
    public Hotel saveHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(Long id){
        return hotelRepository.findById(id).get();
    }
}
