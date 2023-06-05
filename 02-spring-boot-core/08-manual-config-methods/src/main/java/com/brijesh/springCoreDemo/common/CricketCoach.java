package com.brijesh.springCoreDemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    CricketCoach(){
        System.out.println("Constructor:CricketCoach");
    }
    @Override
    public String getCoach() {
        return "Practice forward batting for 10 mins.~~~.";
    }

    @PostConstruct
    public void myStartupMethod(){
        System.out.println("In the Startup Method");
    }

    //    Cleanup Method
    @PreDestroy
    public void myCleanupMethod(){
        System.out.println("In the Cleanup Method");
    }

}
