package com.tms.rakhubovskiy.controller;

import com.tms.rakhubovskiy.model.User;
import com.tms.rakhubovskiy.repository.UserRepository;
import com.tms.rakhubovskiy.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/registration")
    public String registr(Model model){
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "registration";
    }

    @PostMapping("/registration")
    public String doRegistration(Model model, User newUser, BindingResult bindingResult){
        userValidator.validate(newUser, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "../../error";
        }
        userRepository.save(newUser);
        return "user_page";
    }



   /* @GetMapping("/user_page")
    public String findAll(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "user_list";
    }*/
}
