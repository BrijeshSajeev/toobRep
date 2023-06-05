package com.brijesh.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennishCoach implements Coach{

    @Override
    public String getCoach() {
        return "Practice cut";
    }
}
