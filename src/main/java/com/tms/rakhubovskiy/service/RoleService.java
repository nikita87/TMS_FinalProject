package com.tms.rakhubovskiy.service;

import com.tms.rakhubovskiy.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findRoleById();
    List<Role> findAllRoles();
}
