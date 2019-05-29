package com.loser.ecommerce.vo;


import com.loser.ecommerce.entity.Users;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoVo extends Users implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(hidden = true)
    private String companyName;
    @ApiModelProperty(hidden = true)
    private String industryName;
    @ApiModelProperty(hidden = true)
    private String roleName;

    /**
     * 选择的门店
     */
    @ApiModelProperty("门店，多个用','隔开")
    private String storesUuids;

}
