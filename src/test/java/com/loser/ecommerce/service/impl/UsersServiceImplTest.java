package com.loser.ecommerce.service.impl;


import com.loser.ecommerce.base.enums.GenderEnum;
import com.loser.ecommerce.base.enums.UserStatusEnum;
import com.loser.ecommerce.entity.Users;
import com.loser.ecommerce.service.IUsersService;
import com.loser.ecommerce.shiro.ShiroUtil;
import com.loser.ecommerce.util.ToolUtil;
import org.junit.Assert;
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
public class UsersServiceImplTest {

    @Autowired
    private IUsersService service;

    @Test
    //@Transactional
    public void initAdmin(){
        String pwd = "x";
        Users user = new Users();
        user.setGender(GenderEnum.Male.getGenderCode());
        user.setUserStatus(UserStatusEnum.InUse.getStatusCode());
        user.setRealName("超级管理员");
        String salt = ShiroUtil.getRandomSalt(6);
        user.setSalt(salt);
        user.setPassword(ShiroUtil.md5(pwd, salt));
        user.setUsername("admin");
        Assert.assertTrue(service.save(user));
    }
    @Test
    @Transactional
    public void createRandomUsers(){
        String defPwd = "x";
        List<Users> lst =new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Users u = new Users();
            u.setGender(i%2==0?0:1);
            String name = ToolUtil.getRandomNumbrString(4);
            u.setRealName(name);
            u.setUsername(name);
            String salt = ShiroUtil.getRandomSalt(6);
            u.setSalt(salt);
            u.setPassword(ShiroUtil.md5(defPwd, salt));
            u.setUserStatus(UserStatusEnum.InUse.getStatusCode());
            lst.add(u);
        }
        Assert.assertTrue(this.service.saveBatch(lst));
    }
}