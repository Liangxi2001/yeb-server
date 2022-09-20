package com.yebProject.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yebProject.server.mapper.DepartmentMapper;
import com.yebProject.server.pojo.Department;
import com.yebProject.server.pojo.RespBean;
import com.yebProject.server.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    /**
     * 获取所有部门
     * @return
     */
    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartments(-1);
    }

    @Override
    public RespBean addDep(Department department) {
        department.setEnabled(true);
        departmentMapper.addDep(department);
        if(1 == department.getResult()){
            return RespBean.success("添加成功！",department);
        }
        return RespBean.error("添加失败！");
    }

    @Override
    public RespBean deleteDep(Integer id) {
        Department department = new Department();
        department.setId(id);
        departmentMapper.deleteDep(department);
        if (-2 == department.getResult()){
            return RespBean.error("该部门是父部门，删除失败！");
        }
        if (-1 == department.getResult()){
            return RespBean.error("该部门下有员工，删除失败！");
        }
        if (1 == department.getResult()){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
