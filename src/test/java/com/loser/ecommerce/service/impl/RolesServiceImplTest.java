package com.loser.ecommerce.service.impl;


import com.loser.ecommerce.entity.RoleUsers;
import com.loser.ecommerce.entity.Roles;
import com.loser.ecommerce.mapper.RoleUsersMapper;
import com.loser.ecommerce.service.IRolesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RolesServiceImplTest {
    @Autowired
    private IRolesService service;

    @Autowired
    private RoleUsersMapper roleUsersMapper;

    @Test
    public void insertRole(){
        Roles roles = new Roles();
        roles.setRoleName("admin");
        service.save(roles);
    }

    @Test
    @Transactional
    public void insertRoleUsers(){
        RoleUsers roleUsers = new RoleUsers();
        roleUsers.setRoleUuid("test");
        roleUsers.setUserUuid("test");
        roleUsersMapper.insert(roleUsers);

        List<String> list = new ArrayList<>();
        list.add(roleUsers.getRoleUserUuid());
        roleUsersMapper.deleteBatchIds(list);
        int i = 1 / 0;
    }
}