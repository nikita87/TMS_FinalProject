package com.tms.rakhubovskiy.controller;

import com.tms.rakhubovskiy.model.User;
import com.tms.rakhubovskiy.service.UserService;
import com.tms.rakhubovskiy.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController extends BaseController {

    private final UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String index(){
        return "/index";
    }

    @GetMapping(value = "/login")
    public String login(){
        return "/login";
    }

    @GetMapping(value = "/registration")
    public String registr(Model model){
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "/registration";
    }

    @PostMapping(value = "/registration")
    public String doRegistration(Model model, User newUser, BindingResult bindingResult){
        userValidator.validate(newUser, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/error";
        }

        User checkUser = userService.saveUser(newUser);
        if (checkUser != null){
            return "/travelPlanner";
        }
        model.addAttribute("error", "This username already exist. Please enter another one.");
        return "/registration";
    }

}
