package com.yebProject.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 此间凉汐
 * @date 2022/4/1 10:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespPageBean {

    /**
     * 总条数
     */
    private Long total;
    /**
     * 数据列表
     */
    private List<?> data;
}
