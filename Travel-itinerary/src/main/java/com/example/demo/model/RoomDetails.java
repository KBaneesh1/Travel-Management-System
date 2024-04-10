package com.example.demo.model;

public class RoomDetails{
    
    private String hotelName, address;

    private int numACRooms;
    private String ACAmenities;
    private double ACpricePerNight;

    private int numNonACRooms;
    private String NonACAmenities;
    private double NonACpricePerNight;
    
    public RoomDetails(){}

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public int getNumACRooms() {
        return numACRooms;
    }
    public void setNumACRooms(int numACRooms) {
        this.numACRooms = numACRooms;
    }
    public String getACAmenities() {
        return ACAmenities;
    }
    public void setACAmenities(String aCAmenities) {
        ACAmenities = aCAmenities;
    }
    public double getACpricePerNight() {
        return ACpricePerNight;
    }
    public void setACpricePerNight(double aCpricePerNight) {
        ACpricePerNight = aCpricePerNight;
    }

    public int getNumNonACRooms() {
        return numNonACRooms;
    }
    public void setNumNonACRooms(int numNonACRooms) {
        this.numNonACRooms = numNonACRooms;
    }
    public String getNonACAmenities() {
        return NonACAmenities;
    }
    public void setNonACAmenities(String nonACAmenities) {
        NonACAmenities = nonACAmenities;
    }
    public double getNonACpricePerNight() {
        return NonACpricePerNight;
    }
    public void setNonACpricePerNight(double nonACpricePerNight) {
        NonACpricePerNight = nonACpricePerNight;
    }
    
}
