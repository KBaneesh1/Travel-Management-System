package com.example.demo.controller;

import com.example.demo.model.Transport;
// import com.example.demo.model.Car;
import com.example.demo.model.Hotel;
import com.example.demo.model.Package;
import com.example.demo.model.HotelRoomDetails;
import com.example.demo.services.HotelService;
import com.example.demo.services.RoomService;
import com.example.demo.repository.PackageRepository;
import com.example.demo.model.User;
import com.example.demo.model.UserPackage;
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
    private PackageRepository packageRepository;
    // private BusService busService;

    

    public PackageController(HotelService hotelService, RoomService roomService, 
    TransportServiceImpl transportService, PackageRepository packageRepository) {
        
        super();
        this.hotelService = hotelService;
        this.roomService = roomService;
        this.transportService = transportService;
        this.packageRepository = packageRepository;
    }


    @ModelAttribute("package") // Initialize the session attribute
    public Package.Builder initializeUsername() {
        return new Package.Builder(); // Initial value for the username
    }

    @GetMapping("/package/{baseLocation}")
    public String viewHotelsTransport(@PathVariable("baseLocation") String baseLocation, Model model, @SessionAttribute("package") Package.Builder p) {
        model.addAttribute("baseLocation", baseLocation);


        List<HotelRoomDetails> allDetails = new ArrayList<HotelRoomDetails>(); 
        List<Hotel> hotelInfo = hotelService.getHotelsByBaseLocation(baseLocation);
        
        for (Hotel hotel : hotelInfo) {
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
    @SessionAttribute("package") Package.Builder p, Model model) {
        System.out.println(baseLocation);
        p.setName(packageName).setBaseLocation(baseLocation);
        System.out.println("Package is after setting: " + p.getName());

        model.addAttribute("package", p);
        return "redirect:/package/" + baseLocation;
        // return "redirect:/transport";
    }

    @GetMapping("/package/{baseLocation}/{hotelId}/add_hotel")
    public String addHotelToPackage(@PathVariable("baseLocation") String baseLocation, @PathVariable("hotelId") Long hotelId, Model model, 
    @SessionAttribute("package") Package.Builder p) {
        Hotel hotel = hotelService.getHotelById(hotelId);

        p.addHotel(hotel);
        System.out.println("Hotels chosen are");
        List<Hotel> hotels = p.getHotels();
        for (Hotel hot : hotels) {
            System.out.println(hot.getName());
        }

        model.addAttribute("package", p);
        model.addAttribute("baseLocation", baseLocation);
        // return "redirect:/package/" + baseLocation;
        return "redirect:/package/" + baseLocation;
    }


    @GetMapping("/package/{baseLocation}/{transportId}/add_transport")
    public String addTransportToPackage(@PathVariable("baseLocation") String baseLocation, @PathVariable("transportId") Long transportId, Model model, 
    @SessionAttribute("package") Package.Builder p) {
        Transport transport = transportService.getTransportById(transportId);

        p.transport(transport);
        System.out.println("Transport in this package is: " + p.getTransport().getVehicleName());
        model.addAttribute("package", p);
        model.addAttribute("baseLocation", baseLocation);
        return "redirect:/package/" + baseLocation;
    }

    @GetMapping("/package/{baseLocation}/confirm_package")
    public String addTransportToPackage(@PathVariable("baseLocation") String baseLocation, Model model, 
    @SessionAttribute("package") Package.Builder p) {

        Package new_package = p.build();
        packageRepository.save(new_package);
        System.out.println("Transport in this package is: " + p.getTransport().getVehicleName());
        model.addAttribute("packages", new_package);
        model.addAttribute("baseLocation", baseLocation);
        return "display_package";
    }

    @GetMapping("/display_package/choose_package")
    public String choosePackage(@PathVariable("baseLocation") String baseLocation, Model model){
        List<Package> pack = packageRepository.findByBaseLocation(baseLocation);
        model.addAttribute("packages", pack);
        model.addAttribute("baseLocation", baseLocation);
        return "display_package";
    }
    @GetMapping("/display_package/{baseLocation}/{package_id}")
    public String selectPackage(@SessionAttribute("user") User user,@PathVariable("baseLocation") String baseLocation,@PathVariable("package_id") Long package_id)
    {
        Package pack = packageRepository.findById(package_id).orElse(null);
        UserPackage userPackage = new UserPackage();
        userPackage.setPack(pack);
        userPackage.setUser(user);
        
        return "home";
    }
    // @GetMapping("/display_package/{baseLocation}")
}