package com.tms.rakhubovskiy.controller;

import com.tms.rakhubovskiy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String index(){
        return "/index";
    }
}
