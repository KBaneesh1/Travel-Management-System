package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Hotel;
import com.example.demo.model.HotelRoomInventory;
import com.example.demo.services.HotelRoomInventoryService;
import com.example.demo.services.HotelService;
import com.example.demo.services.RoomTypeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class HotelController {

    private HotelService hotelService;
    private RoomTypeService roomTypeService;
    private HotelRoomInventoryService hotelRoomInventoryService;

    public HotelController(HotelService hotelService, RoomTypeService roomTypeService, HotelRoomInventoryService hotelRoomInventoryService) {
        super();
        this.hotelService = hotelService;
        this.roomTypeService = roomTypeService;
        this.hotelRoomInventoryService = hotelRoomInventoryService;
    }

    @GetMapping("/hotels")
    public String listHotels(Model model) {
        model.addAttribute("hotels", hotelService.getAllHotels());
        return "hotels";
    }
    

    @GetMapping("/hotels/new")
    public String addHotel(Model model){
        Hotel newHotel = new Hotel();
        HotelRoomInventory newACRoomDetails = new HotelRoomInventory();
        HotelRoomInventory newNonACRoomDetails = new HotelRoomInventory();
        //Long acId = RoomTypeService.findRoomIdByRoomType("AC");
        //Long nonAcId = RoomTypeService.findRoomIdByRoomType("Non-AC");

        newACRoomDetails.setRoomTypeId(1L); 
        newNonACRoomDetails.setRoomTypeId(2L);
        //System.out.println("ca room");
        //System.out.println(newACRoomDetails);
        //System.out.println("\n nonac room");
        //System.out.println(newNonACRoomDetails);
        model.addAttribute("hotel", newHotel);
        model.addAttribute("ACRoomDetails", newACRoomDetails);
        model.addAttribute("NonACRoomDetails", newNonACRoomDetails);
        return "add_hotel";
    }
    
    @PostMapping("/hotels/new")
    public String saveHotel(@ModelAttribute("hotel") Hotel hotel, 
                            @ModelAttribute("ACRoomDetails") HotelRoomInventory ACRoomDetails, 
                            @ModelAttribute("NonACRoomDetails") HotelRoomInventory NonACRoomDetails) {
        
        // System.out.println("AC rooms details");
        // System.out.println(ACRoomDetails.getAmenities());
        // System.out.println(ACRoomDetails.getNumberOfRooms());
        // System.out.println(ACRoomDetails.getPricePerNight());

        // System.out.println("NonAC rooms details");
        // System.out.println(NonACRoomDetails.getAmenities());
        // System.out.println(NonACRoomDetails.getNumberOfRooms());
        // System.out.println(NonACRoomDetails.getPricePerNight());

        hotelService.saveHotel(hotel);
        
        ACRoomDetails.setHotelId(hotel.getId());
        ACRoomDetails.setRoomTypeId(1L);
        hotelRoomInventoryService.saveRoomDetails(ACRoomDetails);

        NonACRoomDetails.setHotelId(hotel.getId());
        NonACRoomDetails.setRoomTypeId(2L);
        hotelRoomInventoryService.saveRoomDetails(NonACRoomDetails);

        return "redirect:/hotels";
    }

}