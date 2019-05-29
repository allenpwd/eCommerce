package com.loser.ecommerce.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.loser.ecommerce.base.controller.BaseController;
import com.loser.ecommerce.base.msg.ResponseMsg;
import com.loser.ecommerce.entity.Roles;
import com.loser.ecommerce.entity.Users;
import com.loser.ecommerce.service.IRolesService;
import com.loser.ecommerce.service.IUsersService;
import com.loser.ecommerce.shiro.ShiroUtil;
import com.loser.ecommerce.vo.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 */
@RestController
@RequestMapping("/users")
@Api(tags="帐号信息")
public class UsersController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUsersService usersService;

    @Autowired
    private IRolesService rolesService;


    @ApiOperation("冻结/解冻")
    @PutMapping("/{id}/{status}")
    @RequiresRoles(value={"超级管理员"})
    public ResponseMsg updateStatus(@PathVariable String id
            , @PathVariable@ApiParam("0:正常 1:冻结") Integer status) {
        Users users = null;
        if (status != 0 && status != 1) {
            return ResponseMsg.failed("操作失败").push("failMsg", "status只能为0或1");
        }
        try {
            users = usersService.getById(id);
            if (users == null) {
                return ResponseMsg.failed("操作失败").push("failMsg", "帐号不存在");
            }
            users = new Users();
            users.setUserUuid(id);
            users.setUserStatus(status);
            if (!usersService.updateById(users)) {
                return ResponseMsg.failed("操作失败");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return ResponseMsg.failed("操作出错").push("failMsg", e.getMessage());
        }
        return ResponseMsg.success("操作成功").push("result", users);
    }

    @ApiOperation("删除帐号")
    @DeleteMapping("/{id}")
    public ResponseMsg delete(@PathVariable String id) {
        try {
            if (!usersService.removeById(id)) {
                return ResponseMsg.failed("删除失败");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return ResponseMsg.failed("删除出错").push("failMsg", e.getMessage());
        }
        return ResponseMsg.success("删除成功");
    }

    @ApiOperation("按照id查询")
    @GetMapping("/{id}")
    public ResponseMsg get(@PathVariable String id) {
        Users users = null;
        try {
            users = usersService.getById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return ResponseMsg.failed("查询出错").push("failMsg", e.getMessage());
        }
        return ResponseMsg.success("查询成功").push("result", users);
    }

    @GetMapping("/test")
    @Transactional()
    public ResponseMsg test() {
        Roles roles = rolesService.getById("aefbdbf5200d4cb6b909bde0fa6f96cc");
        roles.setCreateDate(LocalDateTime.now());
        rolesService.updateById(roles);

        roles = new Roles();
        roles.setRoleDesc("test");
        roles.setRoleName("test");
        rolesService.save(roles);
        return ResponseMsg.success("删除成功");
    }
}
