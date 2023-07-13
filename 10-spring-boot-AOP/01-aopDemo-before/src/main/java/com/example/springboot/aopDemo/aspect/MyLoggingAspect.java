package com.example.springboot.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLoggingAspect {

    @Before("execution(* DemoDaoFunction())")
    public void loggingFunc(){

        System.out.println(getClass()+"In Logging Class .");

    }

}
