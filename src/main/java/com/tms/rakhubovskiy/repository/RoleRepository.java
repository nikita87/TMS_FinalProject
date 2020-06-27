package com.tms.rakhubovskiy.repository;

import com.tms.rakhubovskiy.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("from Role r where r.id=1L")
    List<Role> findRoleById();
}
