package com.loser.ecommerce.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Login_Logs")
public class LoginLogs implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("User_Login_Uuid")
    private String userLoginUuid;

    @TableId("User_Uuid")
    private String userUuid;

    @TableField("Account")
    private String account;

    @TableField("Login_Ip")
    private String loginIp;

    @TableField("Login_Date")
    private LocalDateTime loginDate;


}
