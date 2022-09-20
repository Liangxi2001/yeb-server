package com.yebProject.server.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yebProject.server.pojo.Department;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author liangxi
 * @since 2022-03-22
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments(Integer parentId);

    /**
     * 添加部门
     * @param department
     */
    void addDep(Department department);


    void deleteDep(Department department);
}
