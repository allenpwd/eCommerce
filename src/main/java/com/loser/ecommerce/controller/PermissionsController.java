package com.loser.ecommerce.controller;


import com.loser.ecommerce.base.controller.BaseController;
import com.loser.ecommerce.base.msg.ResponseMsg;
import com.loser.ecommerce.service.IPermissionsService;
import com.loser.ecommerce.vo.PermissionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 */
@RestController
@RequestMapping("/permissions")
@Api(value = "PermissionsController", tags = "权限操作类")
public class PermissionsController extends BaseController {

    @Autowired
    private IPermissionsService permissionsService;

    @GetMapping("list")
    @ApiOperation("根据角色权限查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="roleUuid",value="角色Id",paramType="query")
    })
    public ResponseMsg list(@RequestParam String roleUuid){
        List<PermissionVo> permissions = permissionsService.selectPermissionByRole(roleUuid);
        return ResponseMsg.success().push(permissions);
    }

}
