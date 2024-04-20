// CarService.java
package com.example.demo.serviceImpl;

// import com.example.demo.model.BaseLocation;
import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.services.TransportService;
import java.time.LocalDate;
import java.util.List;

@Service
public class CarService implements TransportService<Car> {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getVehicleByBaseLocation(String baseloc) {
        // Implement logic to get all cars based on userStartDate, userEndDate, and base location
        return carRepository.findCarsByBaseLocation(baseloc);
    }

    @Override
    public void addVehicle(Car vehicle) {
        carRepository.save(vehicle);
    }

    @Override
    public Car getVehicleById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteVehicle(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car updateVehicle(Long id, Car vehicle) {
        Car existingCar = getVehicleById(id);
        if (existingCar != null) {
            existingCar.setVehicleName(vehicle.getVehicleName());
            existingCar.setCapacity(vehicle.getCapacity());
            existingCar.setPricePerDay(vehicle.getPricePerDay());
            existingCar.setDriverInfo(vehicle.getDriverInfo());
            existingCar.setBaseLocation(vehicle.getBaseLocation());
            return carRepository.save(existingCar);
        }
        return null;
    }
}
