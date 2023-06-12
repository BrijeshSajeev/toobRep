package com.spring_boot.springrestcrud.rest;

import com.spring_boot.springrestcrud.entity.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @GetMapping("/customers")
    public List<Customer> getCustomer(){
        List<Customer> li= new ArrayList<Customer>();
        li.add(new Customer("Brijesh","Sajeev","brijesh@gmail.com"));
        li.add(new Customer("Sherbin","Silas","serbin@gmail.com"));
        li.add(new Customer("Ashik","Jenly","ashik@gmail.com"));

        return li;



    }
}
