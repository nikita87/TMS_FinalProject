package com.tms.rakhubovskiy.service;

import com.tms.rakhubovskiy.model.User;
import com.tms.rakhubovskiy.repository.RoleRepository;
import com.tms.rakhubovskiy.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
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
        log.debug("Searching user by username: {}", username);
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User findUserById(Long id) {
        log.debug("Searching users by id: {}", id);
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        log.debug("Searching for an all users");
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long userId) {
        log.debug("Deletion user by id:{}", userId);
        userRepository.deleteById(userId);
    }

    @Override
    public User saveUser(User user) {
        User checkUser = userRepository.findUserByUsername(user.getUsername());
        if (checkUser == null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(roleRepository.findRoleById());
            log.debug("users received for saving: {}", user);
            return userRepository.save(user);
        }
        log.debug("user not save");
        return null;
    }
}
