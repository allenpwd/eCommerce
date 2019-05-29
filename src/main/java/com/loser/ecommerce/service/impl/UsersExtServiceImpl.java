package com.loser.ecommerce.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.loser.ecommerce.entity.UsersExt;
import com.loser.ecommerce.mapper.UsersExtMapper;
import com.loser.ecommerce.service.IUsersExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersExtServiceImpl extends ServiceImpl<UsersExtMapper, UsersExt> implements IUsersExtService {

    @Autowired
    private UsersExtMapper usersExtMapper;

    @Override
    public UsersExt selectOneUserExtByUsername(String username) {
        return this.usersExtMapper.selectOneUserExtByUsername(username);
    }

    @Override
    public IPage<UsersExt> search(int pageNumber, int pageSize) {
        return this.usersExtMapper.selectPage(new Page<>(pageNumber, pageSize), new QueryWrapper());
    }
}
