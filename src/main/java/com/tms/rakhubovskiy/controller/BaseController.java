package com.tms.rakhubovskiy.controller;


import com.tms.rakhubovskiy.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class BaseController {
    protected Long getUserId(){
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getId();
    }

}
