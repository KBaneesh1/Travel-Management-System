package com.example.demo.model;
import java.util.List;

import java.util.ArrayList;

import jakarta.persistence.*;




public class Package {
    // there can be many hotels for one package, only one transport
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long package_id;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pack_id")
    private ArrayList<Hotel> hotels;

    private Transport transport;

    public Package() {
        hotels = new ArrayList<>();
    }

    // Method to add a hotel to the package
    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    // Method to set the transport for the package
    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    // Getters and setters for hotels and transport
    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Transport getTransport() {
        return transport;
    }

}


/*
Usage:  
Package travelPackage = new Package();

Hotel hotel1 = new Hotel("Hotel A", ...); // Instantiate Hotel with appropriate parameters
Hotel hotel2 = new Hotel("Hotel B", ...); // Instantiate another Hotel

Transport transport = new Transport("Flight XYZ", ...); // Instantiate Transport

travelPackage.addHotel(hotel1);
travelPackage.addHotel(hotel2);
travelPackage.setTransport(transport);

 */