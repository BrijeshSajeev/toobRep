package com.brijesh.springCoreDemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TennishCoach implements Coach{

    TennishCoach(){
        System.out.println("Constructor:TennishCoach");
    }
    @Override
    public String getCoach() {
        return "Practice cut";
    }
}
