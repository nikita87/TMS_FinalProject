package com.rakhubovskiy.travelplanningservice.controller;

import com.rakhubovskiy.travelplanningservice.model.User;
import com.rakhubovskiy.travelplanningservice.service.UserService;
import com.rakhubovskiy.travelplanningservice.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping(value = "/user_page")
    public String userPage(){
        return "/user_page";
    }







}
