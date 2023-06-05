package com.brijesh.springCoreDemo.rest;

 import com.brijesh.springCoreDemo.common.Coach;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.beans.factory.annotation.Configurable;
 import org.springframework.beans.factory.annotation.Qualifier;
 import org.springframework.beans.factory.config.ConfigurableBeanFactory;
 import org.springframework.context.annotation.Scope;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RestController;

@RestController

public class DemoRestController {

    private Coach myCoach;

// (@Autowired) Search the object Coach in th Spring Container
    @Autowired
   public void setCoach(@Qualifier("newSwimCoach") Coach theCoach){
        System.out.println("Constructor: " +getClass().getSimpleName());
        myCoach=theCoach;
    }
    @GetMapping("/dailyworkout")
    public String dailyWorkout(){
       return myCoach.getCoach();
    }

}
