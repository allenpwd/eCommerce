package com.loser.ecommerce.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.loser.ecommerce.entity.UsersExt;
import org.springframework.stereotype.Repository;

/**
 */
@Repository
public interface UsersExtMapper extends BaseMapper<UsersExt> {

    /**
     * 按名查找扩展的
     *
     * @param username
     * @return
     */
    UsersExt selectOneUserExtByUsername(String username);


}
