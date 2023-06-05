package com.brijesh.springCoreDemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{

    FootballCoach(){
        System.out.println("Constructor:FootballCoach");
    }

    @Override
    public String getCoach() {
        return "Pactice to kick the ball";
    }
}
