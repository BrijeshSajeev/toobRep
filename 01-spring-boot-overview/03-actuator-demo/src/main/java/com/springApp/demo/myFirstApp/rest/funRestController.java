package com.springApp.demo.myFirstApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class funRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello Spring";
    }

    @GetMapping("/workouts")
    public String getWorkout(){
        return "Do 100 push-ups";
    }

}
