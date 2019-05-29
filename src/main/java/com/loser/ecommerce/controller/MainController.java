package com.loser.ecommerce.controller;

import com.loser.ecommerce.base.enums.UserStatusEnum;
import com.loser.ecommerce.base.msg.ResponseMsg;
import com.loser.ecommerce.entity.LoginLogs;
import com.loser.ecommerce.entity.UsersExt;
import com.loser.ecommerce.exception.RetailExceptionEnum;
import com.loser.ecommerce.jwt.JwtUtil;
import com.loser.ecommerce.service.IUsersExtService;
import com.loser.ecommerce.shiro.ShiroUsersFactory;
import com.loser.ecommerce.support.HttpKit;
import com.loser.ecommerce.util.IpAdrressUtil;
import com.loser.ecommerce.util.ToolUtil;
import com.loser.ecommerce.vo.UsersVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(value = "MainController", tags = "用户登录退出操作")
@CrossOrigin
@RestController
public class MainController {
    private final static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private IUsersExtService usersService;

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping("/login")
    public ResponseMsg login(@RequestBody UsersVo vo) {

        //1.按用户名和企业代码查找校验用户
        UsersExt user = this.usersService.selectOneUserExtByUsername(vo.getUsername());
        //2.如果没找到用户就返回
        if (ToolUtil.isEmpty(user))
            return ResponseMsg.failed(RetailExceptionEnum.USER_NOT_EXIST.getMessage());
        //3.校验用户状态
        if (UserStatusEnum.InUse.getStatusCode() != user.getUserStatus()) {
            return ResponseMsg.failed(RetailExceptionEnum.USER_FORBIDDEN.getMessage());
        }
        //4.找到用户后，就创建UsernamePasswordToken（用户名和密码原文）
        UsernamePasswordToken upToken = new UsernamePasswordToken(vo.getUsername(), vo.getPassword());
        //5.以上都校验都通过后，最后交给Shiro校验
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(upToken);
            //6.保存登录日志
            String ip = IpAdrressUtil.getIpAdrress(HttpKit.getRequest());
            LoginLogs ll = new LoginLogs();
            ll.setAccount(vo.getUsername());
            ll.setUserUuid(user.getUserUuid());
            ll.setLoginIp(ip);
        } catch (Exception ex) {
            return ResponseMsg.failed(RetailExceptionEnum.USER_PASSWORD_ERROR.getMessage());
        }
        //7.登录成功后生成token
        user.setPassword(vo.getPassword());//把原文交给jjwt加密
        String token = JwtUtil.createToken(ShiroUsersFactory.create(user));
        return ResponseMsg.success().push("token", token);
    }

    @ApiOperation(value = "用户退出", notes = "用户退出")
    @PostMapping("/logout")
    public ResponseMsg logout() {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
            return ResponseMsg.success();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw ex;
        }
    }

}
