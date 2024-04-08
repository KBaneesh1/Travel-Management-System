package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Hotel;
import com.example.demo.services.HotelService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class HotelController {

    private HotelService hotelService;


    public HotelController(HotelService hotelService) {
        super();
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels")
    public String listHotels(Model model) {
        model.addAttribute("hotels", hotelService.getAllHotels());
        return "hotels";
    }
    

    @GetMapping("/hotels/new")
    public String addHotel(Model model){
        Hotel newHotel = new Hotel();
        model.addAttribute("hotel", newHotel);
        return "add_hotel";
    }
    
    @PostMapping("/hotels/new")
    public String saveMovie(@ModelAttribute("hotel") Hotel hotel) {
        hotelService.saveHotel(hotel);
        return "redirect:/hotels";
    }

}
