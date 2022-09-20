package com.yebProject.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yebProject.server.mapper.MenuMapper;
import com.yebProject.server.pojo.Admin;
import com.yebProject.server.pojo.Menu;
import com.yebProject.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liangxi
 * @since 2022-03-22
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Override
    public List<Menu> getMenuByAdminId() {
        Admin principal =(Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer adminId = principal.getId();
        System.out.println(adminId);
        //从redis中获取菜单数据
//        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
//        //如果为空，去数据库获取
//        List<Menu> menus = (List<Menu>) valueOperations.get("menu_" + adminId);
//        if (CollectionUtils.isEmpty(menus)){
//            menus = menuMapper.getMenuByAdminId(adminId);
//            //将数据设置到redis中
//            valueOperations.set("menu_"+adminId,menus);
//        }
        return menuMapper.getMenuByAdminId(adminId);
    }


    /**
     * 根据角色获取菜单列表
     * @return
     */
    @Override
    public List<Menu> getMenusWithRole() {
        return menuMapper.getMenusWithRole();
    }

    /**
     * 查询所有菜单
     * @return
     */
    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }
}
