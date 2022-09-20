package com.yebProject.server.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yebProject.server.pojo.AdminRole;
import org.apache.ibatis.annotations.Param;


/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author liangxi
 * @since 2022-03-22
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    Integer updateAdminRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}
