package com.example.demo.service;

import com.example.demo.model.Bus;
import com.example.demo.model.Car;

import java.util.*;

public abstract interface TransportService {
    List<Car> getAllCars(Date userStartDate , Date userEndDate);
    List<Bus> getAllBuses(Date userStartDate , Date userEndDate);
    void addCar(Car car);
    void addBus(Bus bus);
    Car getCarById(Long id);
    Bus getBusById(Long id);
    
    void deleteCar(Long id);
    void deleteBus(Long id);

    Car updateCar(Long id , Car car); 
    Bus updateBus(Long id , Bus bus); 
    // void addToCart(String vehicleType, Long id);
    
    // List<Map<String, Long>> getCart();
    
    // void clearCart();
}
