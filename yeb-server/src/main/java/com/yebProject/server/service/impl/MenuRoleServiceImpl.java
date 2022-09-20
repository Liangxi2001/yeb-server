package com.yebProject.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yebProject.server.mapper.MenuRoleMapper;
import com.yebProject.server.pojo.MenuRole;
import com.yebProject.server.pojo.RespBean;
import com.yebProject.server.service.IMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liangxi
 * @since 2022-03-22
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;
    @Override
    @Transactional
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        //先删除，后修改
        menuRoleMapper.delete(new QueryWrapper<MenuRole>().eq("rid",rid));
        if (null == mids || 0 == mids.length){
            return RespBean.success("更新成功！");
        }
        Integer result = menuRoleMapper.insertRecord(rid, mids);
        if (result == mids.length){
            RespBean.success("更新成功！");
        }
        RespBean.error("更新失败！");

        return null;
    }
}
