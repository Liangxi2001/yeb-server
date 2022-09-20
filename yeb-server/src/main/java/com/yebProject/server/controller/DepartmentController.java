package com.yebProject.server.controller;


import com.yebProject.server.pojo.Department;
import com.yebProject.server.pojo.RespBean;
import com.yebProject.server.service.IDepartmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liangxi
 * @since 2022-03-22
 */
@RestController
@RequestMapping("/system/config/department")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @ApiOperation("获取所有部门")
    @GetMapping("/")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @ApiOperation("添加部门")
    @PostMapping("/")
    public RespBean addDep(@RequestBody Department department){
        return departmentService.addDep(department);
    }

    @ApiOperation("删除部门")
    @DeleteMapping("/{id}")
    public RespBean deleteDep(@PathVariable Integer id){
        return departmentService.deleteDep(id);
    }

}
