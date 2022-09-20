package com.yebProject.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yebProject.server.pojo.Menu;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liangxi
 * @since 2022-03-22
 */
public interface IMenuService extends IService<Menu> {

    List<Menu> getMenuByAdminId();

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<Menu> getMenusWithRole();

    /**
     * 查询所有菜单
     * @return
     */
    List<Menu> getAllMenus();
}
