package com.loser.ecommerce.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.loser.ecommerce.entity.Permissions;
import com.loser.ecommerce.vo.PermissionVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 */
@Repository
public interface PermissionsMapper extends BaseMapper<Permissions> {

    /**
     * 根据角色获取相对应权限
     * @param roleUuid
     * @return
     */
    List<PermissionVo> selectPermissionByRole(String roleUuid);

}
