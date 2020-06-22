package com.tms.rakhubovskiy.service;

import com.tms.rakhubovskiy.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User findUserByUsername(String username);

    void addUser(User user);

}
