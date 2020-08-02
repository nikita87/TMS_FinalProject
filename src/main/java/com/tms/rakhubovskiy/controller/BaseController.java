package com.tms.rakhubovskiy.controller;

import com.tms.rakhubovskiy.model.Role;
import com.tms.rakhubovskiy.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

public abstract class BaseController {

    protected Long getUserId(){
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getId();
    }

    protected List<Role> getUserRole(){
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getRoles();
    }

    protected String getUserName(){
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getUsername();
    }
}
