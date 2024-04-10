package com.example.demo.model;

import com.example.demo.model.Hotel;
import com.example.demo.model.ACRoom;
import com.example.demo.model.NonACRoom;


public class HotelRoomDetails {

    private Hotel hotel;
    private ACRoom acRoom;
    private NonACRoom nonACRoom;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public ACRoom getAcRoom() {
        return acRoom;
    }

    public void setAcRoom(ACRoom acRoom) {
        this.acRoom = acRoom;
    }

    public NonACRoom getNonACRoom() {
        return nonACRoom;
    }

    public void setNonACRoom(NonACRoom nonACRoom) {
        this.nonACRoom = nonACRoom;
    }
}

