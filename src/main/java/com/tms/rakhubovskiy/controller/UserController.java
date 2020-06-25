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
public class UserController {

    private final UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @GetMapping("/registration")
    public String registr(Model model){
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "/registration";
    }

    @PostMapping("/registration")
    public String doRegistration(Model model, User newUser, BindingResult bindingResult){
        userValidator.validate(newUser, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/error";
        }
        userService.addUser(newUser);
        return "/user_page";
    }

   /* @GetMapping("/user_page")
    public String findAll(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "user_list";
    }*/
}
