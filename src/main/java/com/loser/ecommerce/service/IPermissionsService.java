package com.loser.ecommerce.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.loser.ecommerce.entity.Permissions;
import com.loser.ecommerce.vo.PermissionVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface IPermissionsService extends IService<Permissions> {

    /**
     * 根据角色获取相对应权限
     * @param roleUuid
     * @return
     */
    List<PermissionVo> selectPermissionByRole(String roleUuid);

}
