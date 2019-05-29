package com.loser.ecommerce.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.loser.ecommerce.entity.Permissions;
import com.loser.ecommerce.mapper.PermissionsMapper;
import com.loser.ecommerce.service.IPermissionsService;
import com.loser.ecommerce.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 */
@Service
public class PermissionsServiceImpl extends ServiceImpl<PermissionsMapper, Permissions> implements IPermissionsService {

    @Autowired
    private PermissionsMapper permissionsMapper;

    @Override
    public List<PermissionVo> selectPermissionByRole(String roleUuid) {
        return permissionsMapper.selectPermissionByRole(roleUuid);
    }
}
