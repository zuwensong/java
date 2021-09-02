package com.zuwen.basic.web;

import com.zuwen.basic.aop.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AopController {

    @Log
    @RequestMapping("/log")
    public String testAop() {
        System.out.println("233");
        return "hello aop";
    }
}
