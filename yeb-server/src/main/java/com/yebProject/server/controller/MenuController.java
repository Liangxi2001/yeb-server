package com.yebProject.server.controller;


import com.yebProject.server.pojo.Menu;
import com.yebProject.server.service.IMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liangxi
 * @since 2022-03-22
 */
@RestController
@RequestMapping("/system/config")
public class MenuController {

    @Autowired
    private IMenuService menuService;


    @ApiOperation(value = "通过用户id查询菜单列表")
    @GetMapping("/menu")
    public List<Menu> getMenuByAdminId(){
        return menuService.getMenuByAdminId();
    }


}
