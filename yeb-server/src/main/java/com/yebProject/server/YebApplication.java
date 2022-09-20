package com.yebProject.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 此间凉汐
 * @date 2022/3/22 10:55
 */

@SpringBootApplication
@MapperScan("com.yebProject.server.mapper")
//@EnableScheduling开启定时任务
@EnableScheduling
public class YebApplication {
    public static void main(String[] args) {
        SpringApplication.run(YebApplication.class, args);
    }
}
