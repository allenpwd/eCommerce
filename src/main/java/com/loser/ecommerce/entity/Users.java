package com.loser.ecommerce.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("User_Uuid")
    private String userUuid;

    @NotNull(message = "用户名不能为空")
    @TableField("Username")
    @ApiModelProperty("帐号名称")
    private String username;

    @TableField("Real_Name")
    @ApiModelProperty(hidden = true)
    private String realName;

    //@NotNull(message = "密码不能为空")
    @TableField("Password")
    @ApiModelProperty(hidden = true)
    private String password;

    /**
     * 0:正常 1:冻结
     */
    @TableField("User_Status")
    @ApiModelProperty(hidden = true)
    private Integer userStatus;

    /**
     * 0:female;1:male
     */
    @TableField("Gender")
    @ApiModelProperty(hidden = true)
    private Integer gender;

    /**
     * Auto Create
     */
    @TableField("Create_Date")
    @ApiModelProperty(hidden = true)
    private LocalDateTime createDate;

    @TableField("Remark")
    @ApiModelProperty("备注")
    private String remark;

    @TableField("Salt")
    @ApiModelProperty(hidden = true)
    private String salt;

}
