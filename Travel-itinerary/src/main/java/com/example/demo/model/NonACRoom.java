package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.*;

@Entity
@Table(name = "NonAC_rooms",
       uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "hotelId"})})
public class NonACRoom implements Room{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long hotelId;
    private String roomType="Non-AC Room";
    private String amenities;
    private double PricePerNight;
    private int numRooms;

    public Long getId() {
        return id;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public String getRoomType() {
        return roomType;
    }
    public String getAmenities() {
        return amenities;
    }
    public double getPricePerNight() {
        return PricePerNight;
    }
    public int getNumRooms() {
        return numRooms;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }
    public void setPricePerNight(double pricePerNight) {
        PricePerNight = pricePerNight;
    }
    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

}
