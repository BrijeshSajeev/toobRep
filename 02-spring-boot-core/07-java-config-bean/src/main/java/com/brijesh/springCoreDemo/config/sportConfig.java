package com.brijesh.springCoreDemo.config;

import com.brijesh.springCoreDemo.common.Coach;
import com.brijesh.springCoreDemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class sportConfig {
    @Bean("newSwimCoach")
    public Coach swimCoach(){
        return new SwimCoach();
    }

}
