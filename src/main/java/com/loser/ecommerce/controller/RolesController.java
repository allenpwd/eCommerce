package com.loser.ecommerce.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.loser.ecommerce.base.controller.BaseController;
import com.loser.ecommerce.base.msg.ResponseMsg;
import com.loser.ecommerce.entity.Roles;
import com.loser.ecommerce.service.IRolesService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 */
@RestController
@RequestMapping("/roles")
@Api(tags="角色信息")
public class RolesController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IRolesService iRolesService;

    /**
     * 查询列表
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @ApiOperation("查询列表")
    @GetMapping("/list")
    @ApiImplicitParams({
        @ApiImplicitParam(name="roleName",value="角色名称",paramType="query")
    })
    public ResponseMsg list(@RequestParam(defaultValue = "1")Integer pageNumber
            , @RequestParam(defaultValue = "10")Integer pageSize
            , @RequestParam@ApiParam(hidden = true) Map<String, Object> mapParam) {
        IPage<Roles> page = iRolesService.selectForPage(pageNumber, pageSize, mapParam);
        return ResponseMsg.success().push(page);
    }

    @ApiOperation("新增或者更新")
    @PutMapping("/saveOrUpdate")
    public ResponseMsg saveOrUpdate(@RequestBody @Validated Roles roles, BindingResult bindingResult) {

        try {
            /** 校验数据 begin **/
            if (bindingResult.hasErrors()) {
                StringBuilder sb_failMsg = new StringBuilder();
                for (ObjectError objectError : bindingResult.getAllErrors()) {
                    sb_failMsg.append(objectError.getObjectName() + objectError.getDefaultMessage());
                }
                return ResponseMsg.failed("校验失败").push("failMsg", sb_failMsg.toString());
            }
            iRolesService.saveOrUpdate(roles);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return ResponseMsg.failed("更新出错").push("failMsg", e.getMessage());
        }
        return ResponseMsg.success("操作成功").push("result", roles);
    }

    @ApiOperation("按照id查询")
    @GetMapping("/{id}")
    public ResponseMsg get(@PathVariable String id) {
        Roles Roles = null;
        try {
            Roles = iRolesService.getById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return ResponseMsg.failed("查询出错").push("failMsg", e.getMessage());
        }
        return ResponseMsg.success("查询成功").push("result", Roles);
    }

    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public ResponseMsg delete(@PathVariable String id) {
        try {
            if (!iRolesService.removeById(id)) {
                return ResponseMsg.failed("删除失败");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return ResponseMsg.failed("删除出错").push("failMsg", e.getMessage());
        }
        return ResponseMsg.success("删除成功");
    }

}
