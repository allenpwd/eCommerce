package com.loser.ecommerce.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.loser.ecommerce.entity.Permissions;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xuweibin
 * @date 2019/3/27 - 16:57
 */
@Data
public class PermissionVo extends Permissions {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色id")
    @TableField("Role_Uuid")
    private String roleUuid;

    @ApiModelProperty("是否具有权限")
    private Integer permission;
}
