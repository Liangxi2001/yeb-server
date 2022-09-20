package com.yebProject.server.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yebProject.server.pojo.Role;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author liangxi
 * @since 2022-03-22
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getRoles(Integer adminId);
}
