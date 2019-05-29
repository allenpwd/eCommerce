package com.loser.ecommerce.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.loser.ecommerce.entity.Roles;
import com.loser.ecommerce.entity.Users;
import com.loser.ecommerce.vo.UserInfoVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface IUsersService extends IService<Users> {

    /**
     * 查询出符合条件的uuid
     * @param parameters
     * @return
     */
    List<String> selectUseUuids(HashMap<String,Object> parameters);



}

