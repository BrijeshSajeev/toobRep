package com.spring_boot.springrestcrud.rest;

import com.spring_boot.springrestcrud.entity.Customer;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    private List<Customer> li= new ArrayList<Customer>();

    @PostConstruct
    private void loadCustomer(){
        li.add(new Customer("Brijesh","Sajeev","brijesh@gmail.com"));
        li.add(new Customer("Sherbin","Silas","serbin@gmail.com"));
        li.add(new Customer("Ashik","Jenly","ashik@gmail.com"));
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return li;
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        if(customerId >= li.size() || customerId< 0){
            throw new CustomerNotFoundException("Customer Not Found " +customerId);
        }

        return li.get(customerId);
    }




}
