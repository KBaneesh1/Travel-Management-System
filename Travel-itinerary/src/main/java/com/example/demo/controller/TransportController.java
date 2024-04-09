package com.example.demo.controller;

import com.example.demo.model.Bus;
import com.example.demo.model.Car;

import com.example.demo.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/transport")
public class TransportController {

    @Autowired
    private TransportService transportService;

    @GetMapping
    public String showAllTransports(Model model) {
        List<Car> cars = transportService.getAllCars();
        List<Bus> buses = transportService.getAllBuses();
        model.addAttribute("cars", cars);
        model.addAttribute("buses", buses);
        return "transport";
    }

    @GetMapping("/addCar")
    public String showAddCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "addCar";
    }

    @PostMapping("/addCar")
    public String addCar(@RequestParam("file") MultipartFile file, Car car) {
        System.out.println();
        if (!file.isEmpty()) {
            try {
                byte[] imageBytes = file.getBytes();
                car.setVehicleImage(imageBytes);
            } 
            catch (IOException e) 
            {
                // Handle the exception (e.g., log error, show error message)
                e.printStackTrace();
                // Return an appropriate view indicating the error
                return "error";
            }
        }

        transportService.addCar(car);
        return "redirect:/transport";
    }

    @GetMapping("/addBus")
    public String showAddBusForm(Model model) {
        model.addAttribute("bus", new Bus());
        return "addBus";
    }

    @PostMapping("/addBus")
    public String addBus(@RequestParam(name = "file",required = true) MultipartFile file, Bus bus) {
        if (!file.isEmpty()) {
            try {
                byte[] imageBytes = file.getBytes();
                bus.setVehicleImage(imageBytes);
            } catch (IOException e) {
                // Handle the exception (e.g., log error, show error message)
                e.printStackTrace();
                // Return an appropriate view indicating the error
                return "error";
            }
        }
        transportService.addBus(bus);
        return "redirect:/transport";
    }
}
