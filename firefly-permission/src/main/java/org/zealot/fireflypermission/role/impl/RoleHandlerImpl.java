package org.zealot.fireflypermission.role.impl;

import org.springframework.stereotype.Service;
import org.zealot.fireflybase.entity.permission.Role;
import org.zealot.fireflypermission.role.RoleHandler;

import java.util.List;

@Service(value = "roleHandler")
public class RoleHandlerImpl implements RoleHandler {

    @Override
    public Role createRole(Role role) {
        return null;
    }

    @Override
    public void deleteRoleByIndexCode(String indexCode) {

    }

    @Override
    public void deleteAllRole(List<Role> roleList) {

    }

    @Override
    public Role findRoleByIndexCode(String indexCode) {
        return null;
    }

    @Override
    public List<Role> findAllRole() {
        return null;
    }
}
