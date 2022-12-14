package com.yebProject.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yebProject.server.pojo.Admin;
import com.yebProject.server.pojo.RespBean;
import com.yebProject.server.pojo.Role;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liangxi
 * @since 2022-03-22
 */
public interface IAdminService extends IService<Admin> {
    RespBean login(String username, String password, String code, HttpServletRequest request);
    Admin getAdminByUserName(String username);

    /**
     *根据用户ID查询角色列表
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId);

    List<Admin> getAllAdmins(String keywords);

    /**
     * 更新操作员角色
     * @param adminId
     * @param rids
     * @return
     */
    RespBean updateAdminRole(Integer adminId, Integer[] rids);

    /**
     * 更新当前用户密码
     * @param oldPass
     * @param pass
     * @param adminId
     * @return
     */
    RespBean updateAdminPassword(String oldPass, String pass, Integer adminId);

    /**
     * 更新用户头像
     * @param url
     * @param id
     * @param authentication
     * @return
     */
    RespBean updateAdminUserFace(String url, Integer id, Authentication authentication);
}
