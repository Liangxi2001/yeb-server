package com.yebProject.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yebProject.server.pojo.Employee;
import com.yebProject.server.pojo.RespBean;
import com.yebProject.server.pojo.RespPageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liangxi
 * @since 2022-03-22
 */
public interface IEmployeeService extends IService<Employee> {

    /**
     * 获取所有员工（分页）
     * @param current
     * @param size
     * @param employee
     * @param beginDateScope
     * @return
     */
    RespPageBean getEmployeeByPage(Integer current, Integer size, Employee employee, LocalDate[] beginDateScope);

    /**
     * 获取工号
     * @return
     */
    RespBean maxWorkID();

    /**
     * 添加员工
     * @param employee
     * @return
     */
    RespBean addEmp(Employee employee);

    List<Employee> getEmployee(Integer id);

    /**
     * 获取所有员工账套
     * @param currentPage
     * @param size
     * @return
     */
    RespPageBean getEmployeeWithSalary(Integer currentPage, Integer size);
}
