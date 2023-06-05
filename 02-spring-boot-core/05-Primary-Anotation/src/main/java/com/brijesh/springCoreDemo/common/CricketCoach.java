package com.brijesh.springCoreDemo.common;

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
}
