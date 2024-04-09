package com.example.demo.service;

import com.example.demo.model.Bus;
import com.example.demo.model.Car;

import java.util.List;

public abstract interface TransportService {
    List<Car> getAllCars();
    List<Bus> getAllBuses();
    void addCar(Car car);
    void addBus(Bus bus);
}
