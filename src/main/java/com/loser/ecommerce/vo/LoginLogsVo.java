package com.loser.ecommerce.vo;


import com.loser.ecommerce.entity.LoginLogs;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginLogsVo extends LoginLogs implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("活跃用户数")
    private Integer activeUsers;
    @ApiModelProperty("沉默账号")
    private Integer reticentUsers;
    @ApiModelProperty("活跃率")
    private double actives;
    @ApiModelProperty("日期")
    private String timeDate;
}

