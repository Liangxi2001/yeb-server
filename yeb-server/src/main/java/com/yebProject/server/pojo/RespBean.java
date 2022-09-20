package com.yebProject.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 此间凉汐
 * @date 2022/3/22 19:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object obj;

    /**
     * 成功返回结果
     *
     * @param message
     * @return
     */
    public static RespBean success(String message) {
        return new RespBean(200, message, null);
    }

    public static RespBean success(String message, Object obj) {
        return new RespBean(200, message, obj);
    }

    /**
     * 错误返回结果
     *
     * @param message
     * @return
     */
    public static RespBean error(String message) {
        return new RespBean(500, message, null);
    }

    public static RespBean error(String message, Object obj) {
        return new RespBean(500, message, obj);
    }
}



