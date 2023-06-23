package com.brijesh.springboot.demoSpringSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class CustomConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails brijesh= User.builder()
                .username("brijesh")
                .password("{noop}test123")
                .roles("CEO","EMPLOYEE")
                .build();
        UserDetails sherbin= User.builder()
                .username("sherbin")
                .password("{noop}test123")
                .roles("MANAGER","EMPLOYEE")
                .build();

        UserDetails jenly= User.builder()
                .username("jenly")
                .password("{noop}test123")
                .roles("ADMIN","EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(brijesh,sherbin,jenly);

    }



}
