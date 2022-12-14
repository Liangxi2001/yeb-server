package com.yebProject.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yebProject.server.pojo.Menu;
import com.yebProject.server.pojo.MenuRole;
import com.yebProject.server.pojo.RespBean;
import com.yebProject.server.pojo.Role;
import com.yebProject.server.service.IMenuRoleService;
import com.yebProject.server.service.IMenuService;
import com.yebProject.server.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 此间凉汐
 * @date 2022/3/28 9:54
 */
@RestController
@RequestMapping("/system/config/permiss")
public class PermissController {

    @Autowired
    private IMenuRoleService menuRoleService;
    @Autowired
    private IMenuService menuService;
    @Autowired
    private IRoleService roleService;
    @ApiOperation(value = "获取所有角色信息")
    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.list();
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("/")
    public RespBean addRole(@RequestBody Role role){
        if (!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        if (roleService.save(role)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/role/{rid}")
    public RespBean deleteRole(@PathVariable Integer rid){
        if (roleService.removeById(rid)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @ApiOperation(value = "查询所有菜单")
    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }


    @ApiOperation(value = "根据角色id查询菜单id")
    @GetMapping("/mid/{rid}")
    public List<Integer> getMidByRid(@PathVariable Integer rid){
        return menuRoleService.list(new QueryWrapper<MenuRole>().eq("rid",rid)).stream()
                .map(MenuRole::getMid).collect(Collectors.toList());
    }

    @ApiOperation(value = "更新角色菜单")
    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid,Integer[] mids){
        return menuRoleService.updateMenuRole(rid,mids);
    }
}
