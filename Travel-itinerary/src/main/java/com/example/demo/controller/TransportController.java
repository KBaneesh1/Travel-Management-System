package com.example.demo.controller;

import com.example.demo.model.Bus;
import com.example.demo.model.Car;

import com.example.demo.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/transport")
public class TransportController {

    // private List<Map<String, Long>> cart = new ArrayList<>();

    @Autowired
    private TransportService transportService;

    @GetMapping
    public String showAllTransports(Model model) {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2024, 04, 01);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2024, 04, 10);
        
        List<Car> cars = transportService.getAllCars(cal1 , cal2);
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
    @GetMapping("/editCar/{id}")
    public String editCar(@PathVariable Long id, Model model) {
        Car car = transportService.getCarById(id);
        model.addAttribute("car", car);
        System.out.println("in get edit car");
        return "editCar";
    }
    @PostMapping("/editCar/{id}")
    public String updateCar(@PathVariable("id") Long id, @ModelAttribute Car updatedCar) {
        System.out.println("done dedwed");
        transportService.updateCar(id, updatedCar);
        return "redirect:/transport";
    }

    @GetMapping("/editBus/{id}")
    public String editBus(@PathVariable Long id, Model model) {
        Bus bus = transportService.getBusById(id);
        model.addAttribute("bus", bus);
        return "editBus";
    }
    @PostMapping("/editBus/{id}")
    public String updateBus(@PathVariable("id") Long id, @ModelAttribute Bus updatedBus) {
        transportService.updateBus(id, updatedBus);
        return "redirect:/transport";
    }
    @GetMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable Long id) {
        transportService.deleteCar(id);
        return "redirect:/transport";
    }
    @GetMapping("/deleteBus/{id}")
    public String deleteMovie(@PathVariable Long id) {
        transportService.deleteBus(id);
        return "redirect:/transport";
    }

}
