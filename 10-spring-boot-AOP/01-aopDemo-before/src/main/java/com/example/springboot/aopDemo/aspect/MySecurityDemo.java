package com.example.springboot.aopDemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(299)
public class MySecurityDemo {

    @Before("execution(* Demo*())")
    public void securityFunc(){

        System.out.println(getClass()+"In Security Class .");

    }


}
