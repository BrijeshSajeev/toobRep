package com.brijesh.springboot.demoSpringSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configure->



                configure
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders").hasAnyRole("MANAGER","CEO")
                        .requestMatchers("/systems").hasAnyRole("ADMIN","CEO")
                        .anyRequest()
                        .authenticated()
                )
                .exceptionHandling(configurer->
                        configurer
                                .accessDeniedPage("/accessDenied")
                        )


                .formLogin(form->
                        form
                                .loginPage("/showLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                        )
                .logout(logout -> logout.permitAll()
                );





        return http.build();

    }

}
