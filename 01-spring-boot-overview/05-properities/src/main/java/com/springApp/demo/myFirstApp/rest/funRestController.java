package com.springApp.demo.myFirstApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class funRestController {

//    Injecting Custom values from application .properties
    @Value("${users.name}")
    private String name;
    @Value("${team.name}")
    private String teamName;

    @GetMapping("userDetails")
    public String getUserDetails(){
        return "Name : "+name+" ::: "+"Team name : "+teamName;
    }


    @GetMapping("/")
    public String sayHello(){
        return "Hello Spring";
    }

    @GetMapping("/workouts")
    public String getWorkout(){
        return "Do 100 push-ups";
    }

}
