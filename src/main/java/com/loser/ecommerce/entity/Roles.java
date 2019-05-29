package com.loser.ecommerce.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Roles")
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("Role_Uuid")
    private String roleUuid;

    @TableField("Role_Name")
    private String roleName;

    @TableField("Role_Desc")
    private String roleDesc;

    @TableField("Create_Date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(hidden = true)
    private LocalDateTime createDate;


}
