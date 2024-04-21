// package com.example.demo.services;

// import com.example.demo.model.BaseLocation;
// import com.example.demo.model.Bus;
// import com.example.demo.model.Car;
// import com.example.demo.model.BaseLocation;
// import java.util.*;
// import java.time.*;
// public abstract interface TransportService {
//     List<Car> getAllCars(LocalDate userStartDate , LocalDate userEndDate,BaseLocation baseloc);
//     List<Bus> getAllBuses(LocalDate userStartDate , LocalDate userEndDate,BaseLocation baseloc);

//     // List<Car> getAllCars();
//     // List<Bus> getAllBuses();

//     void addCar(Car car);
//     void addBus(Bus bus);
//     Car getCarById(Long id);
//     Bus getBusById(Long id);
    
//     void deleteCar(Long id);
//     void deleteBus(Long id);

//     Car updateCar(Long id , Car car); 
//     Bus updateBus(Long id , Bus bus); 
//     // void addToCart(String vehicleType, Long id);
    
//     // void getCart();
    
//     // void clearCart();
// }
package com.example.demo.services;

// import com.example.demo.model.BaseLocation;
import com.example.demo.model.Transport;
// import com.example.demo.model.Car;
import java.time.LocalDate;
import java.util.List;

// import org.hibernate.dialect.function.TransactSQLStrFunction;

public interface TransportService<T> {
    List<Transport> getTransportByBaseLocation(String baseloc);

    void addTransport(Transport transport);

    Transport getTransportById(Long id);

    void deleteTransport(Long id);

    Transport updateTransport(Long id, Transport transport);
}
