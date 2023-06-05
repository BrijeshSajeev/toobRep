package com.brijesh.springCoreDemo.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class sportConfig {
    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }

}
