package com.loser.ecommerce.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("Permissions")
public class Permissions implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("Permission_Uuid")
    private String permissionUuid;

    @TableField("User_Uuid")
    private String userUuid;

    @TableField("Permission_Name")
    private String permissionName;

    @TableField("Permission_Description")
    private String permissionDescription;

    @TableField("Permission_Type")
    private String permissionType;

}
