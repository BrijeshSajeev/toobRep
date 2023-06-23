package com.brijesh.springboot.demoSpringSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInController {

    @GetMapping("/showLoginPage")
    public String showLogin(){
        return "login_form";
    }

}
