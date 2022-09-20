package com.yebProject.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yebProject.server.pojo.MenuRole;
import com.yebProject.server.pojo.RespBean;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liangxi
 * @since 2022-03-22
 */
public interface IMenuRoleService extends IService<MenuRole> {

    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
