package com.loser.ecommerce.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.loser.ecommerce.entity.Users;
import com.loser.ecommerce.vo.UserInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */
@Repository
public interface UsersMapper extends BaseMapper<Users> {

    IPage<UserInfoVo> selectUserInfoVoForPage(IPage<UserInfoVo> page, @Param("parameters") Map<String, Object> paramMap);

    /**
     * 统计账号数量
     * @param parameters
     * @return
     */
    Integer selectAccountCount(@Param("parameters")HashMap<String,Object> parameters);

    /**
     * 查询出符合条件的uuid
     * @param parameters
     * @return
     */
    List<String> selectUseUuids(@Param("parameters")HashMap<String,Object> parameters);

}
