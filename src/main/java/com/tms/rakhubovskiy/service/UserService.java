package com.tms.rakhubovskiy.service;

import com.tms.rakhubovskiy.model.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {

    User findUserByUsername(String username);

    User findUserById(Long id);

    List<User> findAll();

    User saveUser(User user);

    void deleteUserById (Long userId);
}
