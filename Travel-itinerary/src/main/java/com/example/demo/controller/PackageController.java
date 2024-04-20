package com.example.demo.controller;

import com.example.demo.model.BaseLocation;
import com.example.demo.model.Bus;
import com.example.demo.model.Car;
import com.example.demo.model.Hotel;
import com.example.demo.model.Package;
import com.example.demo.model.HotelRoomDetails;

import com.example.demo.service.TransportService;
import com.example.demo.serviceImpl.CarService;
import com.example.demo.serviceImpl.BusService;
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

    private HotelService hotelService;
    private RoomService roomService;
    private CarService carService;
    private BusService busService;

    

    public PackageController(HotelService hotelService, RoomService roomService, 
    CarService carService, BusService busService) {
        
        super();
        this.hotelService = hotelService;
        this.roomService = roomService;
        this.carService = carService;
        this.busService = busService;

    }

    @GetMapping("/show_hotels_transport/{baseLocation}")
    public String viewHotelsTransport(@PathVariable("baseLocation") String baseLocation, Model model) {
        
        List<HotelRoomDetails> allDetails = new ArrayList<HotelRoomDetails>(); 
        List<Hotel> hotelInfo = hotelService.getHotelsByBaseLocation(baseLocation);

        for (Hotel hotel : hotelInfo) {
            HotelRoomDetails temp = new HotelRoomDetails();
            temp.setHotel(hotel);
            temp.setAcRoom(roomService.getACRoomByHotelId(hotel.getId()));
            temp.setNonACRoom(roomService.getNonACRoomByHotelId(hotel.getId()));
            
            allDetails.add(temp);
        }

        List<Car> cars = CarService.getVehicleByBaseLocation(baseLocation);
        List<Bus> buses = BusService.getVehicleByBaseLocation(baseLocation);
        model.addAttribute("allHotelDetails", allDetails);
        // will this work:
        model.addAttribute("allCarDetails", cars);
        model.addAttribute("allBusDetails", buses);
        return "make_package";
    }

    @GetMapping("/package/add_hotel/{id}")
    public String addHotelToPackage(@PathVariable("id") Long id, Model model) {
        HotelRoomDetails  hotelDetails = new HotelRoomDetails();

        Hotel hotel = hotelService.getHotelById(id);


    }

    @PostMapping("/package/create_package")
    public String createPackage(@RequestParam("packageName") String packageName, Model model) {
        model.addAttribute("package", new Package.Builder(packageName));
        return "package";
    }



}
