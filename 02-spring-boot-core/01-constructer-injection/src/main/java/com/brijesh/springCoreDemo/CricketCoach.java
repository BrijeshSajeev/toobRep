package com.brijesh.springCoreDemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Override
    public String getCoach() {
        return "Practice forward batting for 10 mins.~~~.";
    }
}
