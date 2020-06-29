package com.tms.rakhubovskiy.service;

import com.tms.rakhubovskiy.model.User;
import com.tms.rakhubovskiy.repository.RoleRepository;
import com.tms.rakhubovskiy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        User checkUser = userRepository.findUserByUsername(user.getUsername());
        if (checkUser == null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(roleRepository.findRoleById());
            return userRepository.save(user);
        }
        return null;
    }
}
