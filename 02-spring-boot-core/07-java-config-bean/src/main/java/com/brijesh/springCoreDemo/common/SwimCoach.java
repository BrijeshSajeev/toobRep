package com.brijesh.springCoreDemo.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("Constructor:SwimCoach");
    }
    @Override
    public String getCoach() {
        return "Swim for 2 mins.";
    }
}
