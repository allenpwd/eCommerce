package com.loser.ecommerce.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.loser.ecommerce.entity.Roles;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface IRolesService extends IService<Roles> {

    public IPage<Roles> selectForPage(int pageNumber, int pageSize, Map<String, Object> map_param);

}
