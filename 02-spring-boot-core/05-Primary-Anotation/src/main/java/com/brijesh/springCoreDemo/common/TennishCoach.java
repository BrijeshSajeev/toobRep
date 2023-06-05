package com.brijesh.springCoreDemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TennishCoach implements Coach{

    @Override
    public String getCoach() {
        return "Practice cut";
    }
}
