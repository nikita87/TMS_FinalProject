package com.tms.rakhubovskiy.controller;

import com.tms.rakhubovskiy.model.Event;
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
public class UserController extends BaseController{

    private final CountryService countryService;
    private final CityService cityService;
    private final EventService eventService;
    private final UserService userService;

    @Autowired
    public UserController(CountryService countryService, CityService cityService, EventService eventService, UserService userService) {
        this.countryService = countryService;
        this.cityService = cityService;
        this.eventService = eventService;
        this.userService = userService;
    }

    @GetMapping(value = "/travelPlanner")
    public String findAllEvents(Model model){
        model.addAttribute("events", eventService.findAll());
        return "/travelPlanner";
    }

    @GetMapping(value = "/travelPlanner/{id}")
    public String deleteEvent(@PathVariable("id") long eventId){
        eventService.deleteEventById(eventId);
        return "redirect:/travelPlanner";
    }

    @PostMapping(value = "/travelPlanner")
    public String eventCreate(Event newEvent){
        User user = userService.findUserById(getUserId());
        Long userId = user.getId();
        newEvent.setId(userId);
        newEvent.setUser(user);
        eventService.saveEvent(newEvent);
        return "redirect:/travelPlanner";
    }

    /*@GetMapping(value = "/travelPlanner")
    public String userPageShowCountry(Model model){
        model.addAttribute("countries", countryService.findAll());
        return "/travelPlanner";
    }
*/
}
