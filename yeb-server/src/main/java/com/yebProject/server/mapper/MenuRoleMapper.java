package com.yebProject.server.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yebProject.server.pojo.MenuRole;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author liangxi
 * @since 2022-03-22
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    Integer insertRecord(@Param("rid") Integer rid,@Param("mids") Integer[] mids);
}
