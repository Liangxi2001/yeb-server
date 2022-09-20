package com.yebProject.server.config.security.component;

import com.yebProject.server.pojo.Menu;
import com.yebProject.server.pojo.Role;
import com.yebProject.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 根据请求url，分析角色
 * @author 此间凉汐
 * @date 2022/3/26 12:42
 */
@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private IMenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
//        获取请求url
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<Menu> menus = menuService.getMenusWithRole();
        for (Menu menu : menus) {
//            判断请求url与菜单角色是否匹配
            if(antPathMatcher.match(menu.getUrl(),requestUrl)){
                String[] strings = menu.getRoles().stream().map(Role::getName).toArray(String[]::new);
                return SecurityConfig.createList(strings);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
