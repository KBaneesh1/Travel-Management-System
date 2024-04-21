package com.example.demo.model;
import java.util.List;

import java.util.ArrayList;

//import com.example.demo.model.RoomType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="hotels")
public class Hotel{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name = "hotel_name")
    private String name;

    @Column(name="address")
    private String address;
    //private List<RoomType> rooms = new ArrayList<RoomType>();

    @Column(name="base_location")
    private String baseLocation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public void setBaseLocation(String baseLocation) {
        this.baseLocation = baseLocation;
    }

    

    /* public List<RoomType> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomType> rooms) {
        this.rooms = rooms;
    } */


    
}

/* 
 * hotel has multiple room types. how to represent different number of rooms for different number of room types
 * different room types will have different price.
 * different room types will have different amenities.
 * how to handle dates
 * 
 * Incoming package object contains the information of hotel name, room type, date
 * based on that  we need to find out the details and give the bill.
 */