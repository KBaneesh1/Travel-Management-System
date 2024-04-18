package com.example.demo.controller;

import com.example.demo.model.BaseLocation;
import com.example.demo.model.Bus;
import com.example.demo.model.Car;
import com.example.demo.model.Hotel;
import com.example.demo.model.Package;

import com.example.demo.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.*;
import java.time.*;

@Controller

public class PackageController {
    @GetMapping("/make_package")
    public String viewPackage(@RequestParam("hotel") Hotel hotel,  Model model) {
        Package travelPackage = new Package();
        
        Hotel hotel1 = new Hotel(hotel);
        
        Transport transport = new Transport("Flight XYZ");
        
        travelPackage.addHotel(hotel1);
        travelPackage.addHotel(hotel2);
        travelPackage.setTransport(transport);
        
        model.addAttribute("travelPackage", travelPackage);
        return "package";
    }


    @GetMapping("/package/add_hotel/{id}")
    public String addHotelToPackage(@PathVariable("id") Long id, Model model) {
        
    }
}
