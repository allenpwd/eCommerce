package com.loser.ecommerce.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Role_Users")
@ApiModel("角色用户关联表")
public class RoleUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("Role_User_Uuid")
    private String roleUserUuid;

    @TableField("Role_Uuid")
    private String roleUuid;

    @TableField("User_Uuid")
    private String userUuid;

}
