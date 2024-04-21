package com.example.demo.controller;

import com.example.demo.model.Transport;
// import com.example.demo.model.Car;
import com.example.demo.model.Hotel;
import com.example.demo.model.Package;
import com.example.demo.model.HotelRoomDetails;
import com.example.demo.services.HotelService;
import com.example.demo.services.RoomService;

// import com.example.demo.serviceImpl.CarService;
import com.example.demo.serviceImpl.TransportServiceImpl;
// import com.example.demo.serviceImpl.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.*;
import java.time.*;

@Controller
@SessionAttributes("package")
public class PackageController {

    private HotelService hotelService;
    private RoomService roomService;
    private TransportServiceImpl transportService;
    // private BusService busService;

    

    public PackageController(HotelService hotelService, RoomService roomService, 
    TransportServiceImpl transportService) {
        
        super();
        this.hotelService = hotelService;
        this.roomService = roomService;
        this.transportService = transportService;
    }

    @GetMapping("/package/{baseLocation}")
    public String viewHotelsTransport(@PathVariable("baseLocation") String baseLocation, Model model, @ModelAttribute("package") Package.Builder p) {
        System.out.println("Package name in baseloc is " + p.getName());
        model.addAttribute("baseLocation", baseLocation);


        List<HotelRoomDetails> allDetails = new ArrayList<HotelRoomDetails>(); 
        List<Hotel> hotelInfo = hotelService.getHotelsByBaseLocation(baseLocation);
        
        for (Hotel hotel : hotelInfo) {
            System.out.println(hotel.getName());
            HotelRoomDetails temp = new HotelRoomDetails();
            temp.setHotel(hotel);
            temp.setAcRoom(roomService.getACRoomByHotelId(hotel.getId()));
            temp.setNonACRoom(roomService.getNonACRoomByHotelId(hotel.getId()));
            
            allDetails.add(temp);
        }

        List<Transport> transports = transportService.getTransportByBaseLocation(baseLocation);
        // List<Bus> buses = busService.getVehicleByBaseLocation(baseLocation);
        model.addAttribute("allHotelDetails", allDetails);
        // will this work:
        model.addAttribute("allTransports", transports);
        // model.addAttribute("allBuses", buses);
        return "package";
    }

    
    
    // @GetMapping("/package/add_hotel/{id}")
    // public String addHotelToPackage(@PathVariable("id") Long id, Model model) {
    //     HotelRoomDetails  hotelDetails = new HotelRoomDetails();
    
    //     Hotel hotel = hotelService.getHotelById(id);
    // }
    
    
    @GetMapping("/package/create_package")
    public String createPackage(Model model) {
        model.addAttribute("package", new Package.Builder());
        return "package";
    }
    @PostMapping("/package/create_package")
    public String createPackage(@RequestParam("packageName") String packageName, @RequestParam("baseLocation") String baseLocation, 
    @ModelAttribute("package") Package.Builder p, Model model) {
        System.out.println(baseLocation);
        p.setName(packageName).setBaseLocation(baseLocation);
        System.out.println("Package is after setting: " + p.getName());

        model.addAttribute("package", p);
        return "redirect:/package/" + baseLocation;
        // return "redirect:/transport";
    }

    @GetMapping("/package/{baseLocation}/{hotelId}/add_hotel")
    public String addHotelToPackage(@PathVariable("baseLocation") String baseLocation, @PathVariable("hotelId") Long hotelId, Model model, 
    @ModelAttribute("package") Package.Builder p) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        System.out.println("Hotel Name: " + hotel.getName());

        System.out.println("Package is: " + p.getName());
        p.addHotel(hotel);
        model.addAttribute("package", p);
        // System.out.println("Hotels in package are " + p.getHotels());
        model.addAttribute("baseLocation", baseLocation);
        // return "redirect:/package/" + baseLocation;
        return "home";
    }
}