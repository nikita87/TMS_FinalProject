package com.tms.rakhubovskiy.controller;

import com.tms.rakhubovskiy.model.City;
import com.tms.rakhubovskiy.model.User;
import com.tms.rakhubovskiy.service.CityService;
import com.tms.rakhubovskiy.service.CountryService;
import com.tms.rakhubovskiy.service.EventService;
import com.tms.rakhubovskiy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController extends BaseController{

    private final EventService eventService;
    private final UserService userService;
    private final CountryService countryService;
    private final CityService cityService;

    @Autowired
    public AdminController(EventService eventService, UserService userService, CountryService countryService, CityService cityService) {
        this.eventService = eventService;
        this.userService = userService;
        this.countryService = countryService;
        this.cityService = cityService;
    }

    @GetMapping(value = "/adminTravelPlanner")
    public String adminPage(Model model){
        User user = userService.findUserById(getUserId());
        Long userId = user.getId();
        model.addAttribute("events", eventService.findAllByUserId(userId));
        model.addAttribute("city", cityService.findAll());
        return "/adminTravelPlanner";
    }

    @GetMapping(value = "/adminTravelPlanner/{id}")
    public String deleteCity(@PathVariable("id") long cityId){
        cityService.deleteCityById(cityId);
        return "redirect:/adminTravelPlanner";
    }

    @PostMapping(value = "/adminTravelPlanner")
    public String addCity(City newCity){
        cityService.saveCity(newCity);
        return "redirect:/adminTravelPlanner";
    }
}
