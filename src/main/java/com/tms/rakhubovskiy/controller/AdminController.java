package com.tms.rakhubovskiy.controller;

import com.tms.rakhubovskiy.model.City;
import com.tms.rakhubovskiy.model.Country;
import com.tms.rakhubovskiy.model.Hotel;
import com.tms.rakhubovskiy.service.CityService;
import com.tms.rakhubovskiy.service.CountryService;
import com.tms.rakhubovskiy.service.HotelService;
import com.tms.rakhubovskiy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController extends BaseController{
 private final UserService userService;
    private final CountryService countryService;
    private final CityService cityService;
    private final HotelService hotelService;

    @Autowired
    public AdminController(UserService userService, CountryService countryService, CityService cityService, HotelService hotelService) {
        this.userService = userService;
        this.countryService = countryService;
        this.cityService = cityService;
        this.hotelService = hotelService;
    }

    @GetMapping(value = "/adminTravelPlanner")
    public String adminPage(){
        return "/adminTravelPlanner";
    }

    @GetMapping(value = "/adminTravelPlanner/cityInfo")
    public String cityInfoPage(Model model){
        model.addAttribute("city", cityService.findAll());
        return "/cityInfo";
    }

    @GetMapping(value = "/adminTravelPlanner/countryInfo")
    public String countryInfoPage(Model model){
        model.addAttribute("country", countryService.findAll());
        return "/countryInfo";
    }

    @GetMapping(value = "/adminTravelPlanner/hotelInfo")
    public String hotelInfoPage(Model model){
        model.addAttribute("hotel", hotelService.findAll());
        return "/hotelInfo";
    }

    @GetMapping(value = "/adminTravelPlanner/userInfo")
    public String userInfoPage(Model model){
        model.addAttribute("users", userService.findAll());
        return "/userInfo";
    }

    @GetMapping(value = "/cityInfo/{id}")
    public String deleteCity(@PathVariable("id") long cityId){
        cityService.deleteCityById(cityId);
        return "redirect:/adminTravelPlanner/cityInfo";
    }

    @GetMapping(value = "/countryInfo/{id}")
    public String deleteCountry(@PathVariable("id") long countryId){
        countryService.deleteCountryById(countryId);
        return "redirect:/adminTravelPlanner/countryInfo";
    }

    @GetMapping(value = "/hotelInfo/{id}")
    public String deleteHotel(@PathVariable("id") long hotelId){
        hotelService.deleteHotelById(hotelId);
        return "redirect:/adminTravelPlanner/hotelInfo";
    }

    @GetMapping(value = "/userInfo/{id}")
    public String deleteUser(@PathVariable("id") long userId){
        userService.deleteUserById(userId);
        return "redirect:/adminTravelPlanner/userInfo";
    }

    @PostMapping(value = "/adminTravelPlanner/cityInfo")
    public String addCity(City newCity){
        cityService.saveCity(newCity);
        return "redirect:/adminTravelPlanner/cityInfo";
    }

    @PostMapping(value = "/adminTravelPlanner/countryInfo")
    public String addCountry(Country newCountry){
        countryService.saveCountry(newCountry);
        return "redirect:/adminTravelPlanner/countryInfo";
    }

    @PostMapping(value = "/adminTravelPlanner/hotelInfo")
    public String addHotel(Hotel newHotel){
        hotelService.saveHotel(newHotel);
        return "redirect:/adminTravelPlanner/hotelInfo";
    }
}
