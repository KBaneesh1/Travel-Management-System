package com.example.demo.model;

import org.springframework.context.annotation.Scope;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "hotel_room_inventory")
public class HotelRoomInventory {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)    
    @Column(nullable = false)
    private Long id;

    @Column(name="hotel_id")
    private Long hotelId;
    
    @Column(name="room_type_id")
    private Long roomTypeId;
    
    @Column(name = "number_of_rooms")
    private int numberOfRooms;
    
    @Column(name = "amenities")
    private String amenities;
    
    @Column(name = "price_per_night")
    private double pricePerNight;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    // Other attributes, constructors, getters, setters
    
}
