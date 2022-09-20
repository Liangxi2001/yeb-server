package com.yebProject.util;

import com.yebProject.server.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author 此间凉汐
 * @date 2022/3/31 8:53
 */
public class AdminUtils {
    /**
     * 获取当前登录操作员
     * @return
     */
    public static Admin getCurrentAdmin(){
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
