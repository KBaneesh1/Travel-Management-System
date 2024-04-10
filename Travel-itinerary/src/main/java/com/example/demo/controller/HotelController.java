package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.ACRoom;
import com.example.demo.model.Hotel;
import com.example.demo.model.HotelRoomDetails;
import com.example.demo.model.NonACRoom;
import com.example.demo.services.HotelService;
import com.example.demo.services.RoomService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class HotelController {

    private HotelService hotelService;
    private RoomService roomService;

    public HotelController(HotelService hotelService, RoomService roomService) {
        
        super();
        this.hotelService = hotelService;
        this.roomService = roomService;

    }

    @GetMapping("/hotels")
    public String listHotels(Model model) {
        
        List<HotelRoomDetails> allDetails = new ArrayList<HotelRoomDetails>(); 
        List<Hotel> hotelInfo = hotelService.getAllHotels();

        for (Hotel hotel : hotelInfo) {
            
            HotelRoomDetails temp = new HotelRoomDetails();
            temp.setHotel(hotel);
            temp.setAcRoom(roomService.getACRoomByHotelId(hotel.getId()));
            temp.setNonACRoom(roomService.getNonACRoomByHotelId(hotel.getId()));
            
            allDetails.add(temp);

        }

        model.addAttribute("allHotelDetails", allDetails);
        
        return "hotels";
    }
    

    @GetMapping("/hotels/new")
    public String addHotel(Model model){
        
        HotelRoomDetails hotelDetails = new HotelRoomDetails();
        hotelDetails.setHotel(new Hotel());
        hotelDetails.setAcRoom(new ACRoom());
        hotelDetails.setNonACRoom(new NonACRoom());

        model.addAttribute("hotelDetails", hotelDetails);
        return "add_hotel";
    }
    
    @PostMapping("/hotels/new")
    public String saveHotel(@ModelAttribute("hotelDetails") HotelRoomDetails hotelDetails) {
        
        Hotel hotel = hotelDetails.getHotel();
        hotelService.saveHotel(hotel);

        ACRoom acRoom = hotelDetails.getAcRoom();
        NonACRoom nonacRoom = hotelDetails.getNonACRoom();

        acRoom.setHotelId(hotel.getId());
        nonacRoom.setHotelId(hotel.getId());

        roomService.saveACRoom(acRoom);
        roomService.saveNonACRoom(nonacRoom);
        
        return "redirect:/hotels";
    }

}




/* package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

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
        List<RoomDetails> allDetails = new ArrayList<RoomDetails>(); 

        List<Hotel> hotelInfo = hotelService.getAllHotels();

        for (Hotel hotel : hotelInfo) {
            RoomDetails temp = new RoomDetails();
            List<HotelRoomInventory> roomDetails = hotelRoomInventoryService.getDetailsByHotelId(hotel.getId());

            temp.setHotelName(hotel.getName());
            temp.setAddress(hotel.getAddress());
            
            HotelRoomInventory ACRoomDetails = hotelRoomInventoryService.getRoomTypeDetails(roomDetails, 1L); //1L for AC rooms
            HotelRoomInventory NonACRoomDetails = hotelRoomInventoryService.getRoomTypeDetails(roomDetails, 2L); //1L for AC rooms

            temp.setNumACRooms(ACRoomDetails.getNumberOfRooms());
            temp.setACAmenities(ACRoomDetails.getAmenities());
            temp.setACpricePerNight(ACRoomDetails.getPricePerNight());

            temp.setNumNonACRooms(NonACRoomDetails.getNumberOfRooms());
            temp.setNonACAmenities(NonACRoomDetails.getAmenities());
            temp.setNonACpricePerNight(NonACRoomDetails.getPricePerNight());

            allDetails.add(temp);
        }

        model.addAttribute("allHotelDetails", allDetails);
        //model.addAttribute("roomDetails", hotelRoomInventoryService.getAllRoomDetails());
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
 */