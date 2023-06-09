package com.spring_boot.springrestcrud.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handler(CustomerNotFoundException exe){
        CustomerErrorResponse errRes=new CustomerErrorResponse();
        errRes.setMessage(exe.getMessage());
        errRes.setStatus(HttpStatus.NOT_FOUND.value());
        errRes.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errRes,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> badReqestHandler(Exception exe){
        CustomerErrorResponse errRes=new CustomerErrorResponse();
        errRes.setMessage(exe.getMessage());
        errRes.setStatus(HttpStatus.BAD_REQUEST.value());
        errRes.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errRes,HttpStatus.BAD_REQUEST);
    }
}
