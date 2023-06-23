package com.brijesh.springboot.demoSpringSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/leaders")
    public String viewLeaderPage(){
        return "leader";
    }
    @GetMapping("/systems")
    public String viewSystemPage(){
        return "system";
    }
}
