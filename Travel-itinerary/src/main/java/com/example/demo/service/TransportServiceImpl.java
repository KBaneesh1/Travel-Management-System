package com.example.demo.service;

import com.example.demo.model.BaseLocation;
import com.example.demo.model.Bus;
import com.example.demo.model.Car;
import com.example.demo.repository.BusRepository;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
// import java.util.Optional;

@Service
public class TransportServiceImpl implements TransportService {

    private List<Map<String, Long>> cart = new ArrayList<>();
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BusRepository busRepository;

    @Override
    public List<Car> getAllCars(LocalDate userStartDate , LocalDate userEndDate,BaseLocation baseLocation) {
        return carRepository.findAvailableCars(userStartDate,userEndDate,baseLocation);
    }

    @Override
    public List<Bus> getAllBuses(LocalDate userStartDate , LocalDate userEndDate,BaseLocation baseLocation) {
        return busRepository.findAvailableBuses(userStartDate,userEndDate,baseLocation);
    }

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void addBus(Bus bus) {
        busRepository.save(bus);
    }
    @Override
    public Car getCarById(Long id) {
        Optional<Car> onecar = carRepository.findById(id);
        return onecar.orElse(null);
    }
    @Override
    public Bus getBusById(Long id) {
        Optional<Bus> onebus = busRepository.findById(id);
        return onebus.orElse(null);
    }
    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
    @Override
    public void deleteBus(Long id) {
        busRepository.deleteById(id);
    }
    @Override
    public Car updateCar(Long id, Car updatedcar) {
        // private int releaseYear;
        // private String genre;
        // private String director;
        // private double averageRating;
        System.out.println("inside update car serivice");
        Car existingcar = getCarById(id);
        if (existingcar != null) {
            existingcar.setVehicleName(updatedcar.getVehicleName());
            existingcar.setCapacity(updatedcar.getCapacity());
            existingcar.setPricePerDay(updatedcar.getPricePerDay());
            existingcar.setDriverInfo(updatedcar.getDriverInfo());
            existingcar.setLocation(updatedcar.getLocation());
            // existingcar.setAverageRating((updatedcar.getAverageRating()+existingMovie.getAverageRating())/2);
            System.out.println(existingcar);
            return carRepository.save(existingcar);
        }
        return null;
    }
    @Override
    public Bus updateBus(Long id, Bus updatedbus) {
        // private int releaseYear;
        // private String genre;
        // private String director;
        // private double averageRating;
        Bus existingbus = getBusById(id);
        if (existingbus != null) {
            existingbus.setVehicleName(updatedbus.getVehicleName());
            existingbus.setCapacity(updatedbus.getCapacity());
            existingbus.setPricePerDay(updatedbus.getPricePerDay());
            existingbus.setDriverInfo(updatedbus.getDriverInfo());
            existingbus.setLocation(updatedbus.getLocation());
            // existingbus.setAverageRating((updatedbus.getAverageRating()+existingMovie.getAverageRating())/2);
            return busRepository.save(existingbus);
        }
        return null;
    }


    @Override
    public void addToCart(String vehicleType, Long id) {
        Map<String, Long> item = new HashMap<>();
        item.put("type", vehicleType);
        item.put("id", id);
        cart.add(item);
    }

    @Override
    public List<Map<String, Long>> getCart() {
        return cart;
    }

    @Override
    public void clearCart() {
        cart.clear();
    }

}

