package com.loser.ecommerce.service.impl;


import com.loser.ecommerce.entity.Permissions;
import com.loser.ecommerce.service.IPermissionsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionsServiceImplTest {

    @Autowired
    private IPermissionsService service;
    @Test
    public void insertBath(){
        List<Permissions> lst = new ArrayList<>();
        Permissions p = new Permissions();
        p.setUserUuid("add8b867a85740c0bf306eaa3d5e51e3");
        p.setPermissionName("门店查看");
        lst.add(p);
        p = new Permissions();
        p.setUserUuid("add8b867a85740c0bf306eaa3d5e51e3");
        p.setPermissionName("门店修改");
        lst.add(p);
        Assert.assertTrue(service.saveBatch(lst));
    }
}