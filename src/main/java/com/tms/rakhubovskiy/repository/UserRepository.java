package com.tms.rakhubovskiy.repository;

import com.tms.rakhubovskiy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
    User findUserById(Long id);

    
}
