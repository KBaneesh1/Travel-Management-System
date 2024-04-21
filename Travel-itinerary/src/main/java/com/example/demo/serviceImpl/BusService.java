// // BusService.java
// package com.example.demo.serviceImpl;

// // import com.example.demo.model.BaseLocation;
// import com.example.demo.model.Bus;
// import com.example.demo.repository.BusRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import com.example.demo.services.TransportService;
// import java.time.LocalDate;
// import java.util.List;

// @Service
// public class BusService implements TransportService<Bus> {

//     @Autowired
//     private BusRepository busRepository;

//     @Override
//     public List<Bus> getVehicleByBaseLocation(String baseloc) {
//         // Implement logic to get all buses based on userStartDate, userEndDate, and base location
//         return busRepository.findBusesByBaseLocation(baseloc);
//     }

//     @Override
//     public void addVehicle(Bus vehicle) {
//         busRepository.save(vehicle);
//     }

//     @Override
//     public Bus getVehicleById(Long id) {
//         return busRepository.findById(id).orElse(null);
//     }

//     @Override
//     public void deleteVehicle(Long id) {
//         busRepository.deleteById(id);
//     }

//     @Override
//     public Bus updateVehicle(Long id, Bus vehicle) {
//         Bus existingBus = getVehicleById(id);
//         if (existingBus != null) {
//             existingBus.setVehicleName(vehicle.getVehicleName());
//             existingBus.setCapacity(vehicle.getCapacity());
//             existingBus.setPricePerDay(vehicle.getPricePerDay());
//             existingBus.setDriverInfo(vehicle.getDriverInfo());
//             existingBus.setBaseLocation(vehicle.getBaseLocation());
//             return busRepository.save(existingBus);
//         }
//         return null;
//     }
// }
