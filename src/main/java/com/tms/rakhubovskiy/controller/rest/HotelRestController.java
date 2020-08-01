package com.tms.rakhubovskiy.controller.rest;

import com.tms.rakhubovskiy.model.Hotel;
import com.tms.rakhubovskiy.service.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelRestController {

    private final HotelService hotelService;

    public HotelRestController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping(value = "/travelPlanner/hotels")
    public List<Hotel> getHotelsByCityAndHotelClass(@RequestParam(value = "hotelClass", required = false) String hotelClass){
        return hotelService.findHotelsByHotelClass(hotelClass);
    }
}
