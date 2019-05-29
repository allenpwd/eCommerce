package com.loser.ecommerce.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UsersVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private String userUuid;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("用户密码")
    private String password;
    @ApiModelProperty("性别")
    private Integer gender;
    @ApiModelProperty("真实姓名")
    private String realName;
}
