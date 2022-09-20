package com.yebProject.server.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yebProject.server.pojo.Menu;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author liangxi
 * @since 2022-03-22
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenuByAdminId(Integer id);

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
