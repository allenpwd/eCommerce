package com.loser.ecommerce.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.loser.ecommerce.entity.UsersExt;

public interface IUsersExtService extends IService<UsersExt> {
    /**
     * 通过用户名查找用户信息和权限
     *
     * @param username
     * @return
     */
    UsersExt selectOneUserExtByUsername(String username);

    /**
     * 按条件查找用户（系统管理员专用）
     *
     * @param pageNumber 页码
     * @param pageSize   查询条数
     * @return
     */
    IPage<UsersExt> search(int pageNumber, int pageSize);

}
