package com.example.demo.service;

import com.example.demo.model.Bus;
import com.example.demo.model.Car;
import com.example.demo.repository.BusRepository;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportServiceImpl implements TransportService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BusRepository busRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void addBus(Bus bus) {
        busRepository.save(bus);
    }
}
