package com.yebProject.server.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yebProject.server.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author liangxi
 * @since 2022-03-22
 */
public interface AdminMapper extends BaseMapper<Admin> {

    List<Admin> getAllAdmins(@Param("id") Integer id, @Param("keywords") String keywords);
}
