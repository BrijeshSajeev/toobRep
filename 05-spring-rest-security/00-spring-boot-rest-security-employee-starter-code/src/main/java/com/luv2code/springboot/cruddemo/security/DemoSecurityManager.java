package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityManager {

    @Bean
    public InMemoryUserDetailsManager userDetails(){
        UserDetails john= User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails brijesh= User.builder()
                .username("brijesh")
                .password("{noop}test123")
                .roles("EMPLOYEE","CEO")
                .build();

        UserDetails sherbin= User.builder()
                .username("sherbin")
                .password("{noop}test123")
                .roles("EMPLOYEE","ADMIN")
                .build();


        return new InMemoryUserDetailsManager(john,brijesh,sherbin);
    }

//    Strict Access
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")

                );
    http.httpBasic(Customizer.withDefaults());

    http.csrf(csrf->csrf.disable());

        return http.build();
    }

}
