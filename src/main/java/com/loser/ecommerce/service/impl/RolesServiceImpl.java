package com.loser.ecommerce.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.loser.ecommerce.entity.Roles;
import com.loser.ecommerce.mapper.RoleUsersMapper;
import com.loser.ecommerce.mapper.RolesMapper;
import com.loser.ecommerce.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 */
@Service
public class RolesServiceImpl extends ServiceImpl<RolesMapper, Roles> implements IRolesService {

    @Autowired
    private RoleUsersMapper roleUsersMapper;

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @param map_param
     * @return
     */
    public IPage<Roles> selectForPage(int pageNumber, int pageSize, Map<String, Object> map_param) {
        LambdaQueryWrapper<Roles> lambda = new QueryWrapper<Roles>().lambda();
        if (!CollectionUtils.isEmpty(map_param)) {
            if (map_param.containsKey("roleName")) {
                lambda.like(Roles::getRoleName, map_param.get("roleName"));
            }
        }
        return baseMapper.selectPage(new Page<>(pageNumber, pageSize), lambda);
    }

}
