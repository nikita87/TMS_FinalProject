package com.tms.rakhubovskiy.controller;

import com.tms.rakhubovskiy.model.Event;
import com.tms.rakhubovskiy.model.Role;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EventUserController extends BaseController{

    private final EventService eventService;
    private final UserService userService;
    private final CountryService countryService;
    private final CityService cityService;

    @Autowired
    public EventUserController(EventService eventService, UserService userService, CountryService countryService, CityService cityService) {
        this.eventService = eventService;
        this.userService = userService;
        this.countryService = countryService;
        this.cityService = cityService;
    }

    @GetMapping(value = "/travelPlanner")
    public String getMainPage(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        List<Role> roles = getUserRole();
        boolean admin = false;
        for (Role role : roles) {
            if (role.getName().toString()=="ADMIN"){
                admin = true;
            }
        }
        session.setAttribute("admin", admin);
        User user = userService.findUserById(getUserId());
        Long userId = user.getId();
        model.addAttribute("events", eventService.findAllByUserId(userId));
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

}
