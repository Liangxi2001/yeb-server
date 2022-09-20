package com.yebProject.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yebProject.server.pojo.Department;
import com.yebProject.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liangxi
 * @since 2022-03-22
 */
public interface IDepartmentService extends IService<Department> {

    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments();

    RespBean addDep(Department department);

    RespBean deleteDep(Integer id);
}
