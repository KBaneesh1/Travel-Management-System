package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Hotel;

public interface HotelService {
    List<Hotel> getAllHotels();
    Hotel saveHotel(Hotel hotel);
    Hotel getHotelById(Long id);
    List<Hotel> getHotelsByBaseLocation(String baseLocation);
}
