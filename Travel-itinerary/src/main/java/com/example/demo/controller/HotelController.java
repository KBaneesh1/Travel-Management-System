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
import com.example.demo.model.RoomDetails;

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
        
        RoomDetails roomDetails = new RoomDetails();

        model.addAttribute("hotel", newHotel);
        model.addAttribute("roomDetails", roomDetails);
        return "add_hotel";
    }
    
    @PostMapping("/hotels/new")
    public String saveHotel(@ModelAttribute("hotel") Hotel hotel, 
                            @ModelAttribute("roomDetails") RoomDetails roomDetails) {

        hotelService.saveHotel(hotel);
        
        HotelRoomInventory newACRoomDetails = new HotelRoomInventory();
        HotelRoomInventory newNonACRoomDetails = new HotelRoomInventory();

        newACRoomDetails.setHotelId(hotel.getId());
        newACRoomDetails.setRoomTypeId(1L);
        newACRoomDetails.setAmenities(roomDetails.getACAmenities());
        newACRoomDetails.setPricePerNight(roomDetails.getACpricePerNight());
        newACRoomDetails.setNumberOfRooms(roomDetails.getNumACRooms());
        hotelRoomInventoryService.saveRoomDetails(newACRoomDetails);

        newNonACRoomDetails.setHotelId(hotel.getId());
        newNonACRoomDetails.setRoomTypeId(2L);
        newNonACRoomDetails.setAmenities(roomDetails.getNonACAmenities());
        newNonACRoomDetails.setPricePerNight(roomDetails.getNonACpricePerNight());
        newNonACRoomDetails.setNumberOfRooms(roomDetails.getNumNonACRooms());
        hotelRoomInventoryService.saveRoomDetails(newNonACRoomDetails);

        return "redirect:/hotels";
    }

}
