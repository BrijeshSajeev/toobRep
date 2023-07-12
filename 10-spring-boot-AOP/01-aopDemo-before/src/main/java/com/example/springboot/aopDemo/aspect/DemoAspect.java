package com.example.springboot.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspect {

    @Before("execution(public void DemoDaoFunction())")
    public void demoAspectFunction(){
        System.out.println(getClass()+" Before Functions like Logging and Security");
    }

}
