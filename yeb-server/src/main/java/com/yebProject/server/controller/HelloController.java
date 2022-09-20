package com.yebProject.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 此间凉汐
 * @date 2022/3/23 10:00
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/employee/basic/hello")
    public String hello2(){
        return "/employee/basic/hello";
    }

    @GetMapping("/employee/advanced/hello")
    public String hello3(){
        return "/employee/advanced/hello";
    }
    @GetMapping("/home")
    public String hello4(){
        return "/home";
    }
}
