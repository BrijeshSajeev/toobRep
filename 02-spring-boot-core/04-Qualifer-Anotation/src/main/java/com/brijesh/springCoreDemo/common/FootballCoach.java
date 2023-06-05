package com.brijesh.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{

    @Override
    public String getCoach() {
        return "Pactice to kick the ball";
    }
}
