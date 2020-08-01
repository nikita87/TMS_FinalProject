package com.tms.rakhubovskiy.controller;

import com.tms.rakhubovskiy.model.Event;
import com.tms.rakhubovskiy.model.Expenditure;
import com.tms.rakhubovskiy.model.Role;
import com.tms.rakhubovskiy.model.User;
import com.tms.rakhubovskiy.service.CountryService;
import com.tms.rakhubovskiy.service.EventService;
import com.tms.rakhubovskiy.service.ExpenditureService;
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
    private final ExpenditureService expenditureService;

    @Autowired
    public EventUserController(EventService eventService, UserService userService, CountryService countryService, ExpenditureService expenditureService) {
        this.eventService = eventService;
        this.userService = userService;
        this.countryService = countryService;
        this.expenditureService = expenditureService;
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
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("events", eventService.findAllByUserId(userId));
        model.addAttribute("expenditures", expenditureService.findAllByUserId(userId));
        return "/travelPlanner";
    }

    @GetMapping(value = "/travelPlanner/{id}")
    public String deleteEvent(@PathVariable("id") long eventId,
                              @PathVariable("id") long expId){
        eventService.deleteEventById(eventId);
        expenditureService.deleteExpenditureById(expId);
        return "redirect:/travelPlanner";
    }

    @PostMapping(value = "/travelPlanner/events")
    public String eventCreate(Event newEvent){
        User user = userService.findUserById(getUserId());
        newEvent.setUser(user);
        eventService.saveEvent(newEvent);
        return "redirect:/travelPlanner";
    }

    @PostMapping(value = "/travelPlanner/budget")
    public String eventCreate(Expenditure newExpenditure){
        User user = userService.findUserById(getUserId());
        newExpenditure.setUser(user);
        expenditureService.saveExp(newExpenditure);
        return "redirect:/travelPlanner";
    }
}
