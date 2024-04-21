package com.example.demo.serviceImpl;

// import com.example.demo.model.BaseLocation;
import com.example.demo.model.Transport;
// import com.example.demo.model.Car;
// import com.example.demo.repository.BusRepository;
// import com.example.demo.repository.CarRepository;
import com.example.demo.repository.TransportRepository;
import com.example.demo.services.TransportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
// import java.util.Optional;

@Service
public class TransportServiceImpl implements TransportService<Transport> {

    // private List<Map<String, Long>> cart = new ArrayList<>();
    @Autowired
    private TransportRepository transportRepository;

    // @Autowired
    // private BusRepository busRepository;

    @Override
    public List<Transport> getTransportByBaseLocation(String baseLocation) {
        return transportRepository.findTransportByBaseLocation(baseLocation);
    }
    // @Override
    // public List<Car> getAllCars() {
    //     return carRepository.findAll();
    // }
    // @Override
    // public List<Bus> getAllBuses(LocalDate userStartDate , LocalDate userEndDate,BaseLocation baseLocation) {
    //     return busRepository.findAvailableBuses(userStartDate,userEndDate,baseLocation);
    // }
    // @Override
    // public List<Bus> getAllBuses() {
    //     return busRepository.findAll();
    // }
    @Override
    public void addTransport(Transport transport) {
        transportRepository.save(transport);
    }

    // @Override
    // public void addBus(Bus bus) {
    //     busRepository.save(bus);
    // }
    @Override
    public Transport getTransportById(Long id) {
        Optional<Transport> onetransport = transportRepository.findById(id);
        return onetransport.orElse(null);
    }
    // @Override
    // public Bus getBusById(Long id) {
    //     Optional<Bus> onebus = busRepository.findById(id);
    //     return onebus.orElse(null);
    // }
    @Override
    public void deleteTransport(Long id) {
        transportRepository.deleteById(id);
    }
    // @Override
    // public void deleteBus(Long id) {
    //     busRepository.deleteById(id);
    // }
    @Override
    public Transport updateTransport(Long id, Transport updatedtransport) {
        // private int releaseYear;
        // private String genre;
        // private String director;
        // private double averageRating;
        System.out.println("inside update transport serivice");
        Transport existingtransport = getTransportById(id);
        if (existingtransport != null) {
            existingtransport.setVehicleName(updatedtransport.getVehicleName());
            existingtransport.setVehicleType(updatedtransport.getVehicleType());
            existingtransport.setCapacity(updatedtransport.getCapacity());
            existingtransport.setPricePerDay(updatedtransport.getPricePerDay());
            existingtransport.setDriverInfo(updatedtransport.getDriverInfo());
            existingtransport.setBaseLocation(updatedtransport.getBaseLocation());
            // existingtransport.setAverageRating((updatedtransport.getAverageRating()+existingMovie.getAverageRating())/2);
            System.out.println(existingtransport);
            return transportRepository.save(existingtransport);
        }
        return null;
    }
    // @Override
    // public Bus updateBus(Long id, Bus updatedbus) {
    //     // private int releaseYear;
    //     // private String genre;
    //     // private String director;
    //     // private double averageRating;
    //     Bus existingbus = getBusById(id);
    //     if (existingbus != null) {
    //         existingbus.setVehicleName(updatedbus.getVehicleName());
    //         existingbus.setCapacity(updatedbus.getCapacity());
    //         existingbus.setPricePerDay(updatedbus.getPricePerDay());
    //         existingbus.setDriverInfo(updatedbus.getDriverInfo());
    //         existingbus.setLocation(updatedbus.getLocation());
    //         // existingbus.setAverageRating((updatedbus.getAverageRating()+existingMovie.getAverageRating())/2);
    //         return busRepository.save(existingbus);
    //     }
    //     return null;
    // }


    // @Override
    // public void addToCart(String vehicleType, Long id) {
    //     Map<String, Long> item = new HashMap<>();
    //     // item.put("type", vehicleType);
    //     // item.put("id", id);
    //     cart.add(item);
    // }

    // @Override
    // public void getCart() {
    //     // return cart;
        
    // }

    // @Override
    // public void clearCart() {
    //     cart.clear();
    // }

}

