package com.loser.ecommerce.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.loser.ecommerce.entity.RoleUsers;
import com.loser.ecommerce.entity.Roles;
import com.loser.ecommerce.entity.Users;
import com.loser.ecommerce.mapper.RoleUsersMapper;
import com.loser.ecommerce.mapper.UsersMapper;
import com.loser.ecommerce.service.IUsersService;
import com.loser.ecommerce.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private RoleUsersMapper roleUsersMapper;

    @Override
    public List<String> selectUseUuids(HashMap<String, Object> parameters) {
        return usersMapper.selectUseUuids(parameters);
    }

}
