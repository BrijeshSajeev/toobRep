package com.example.springboot.aopDemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountImpl implements AccountDao {
    @Override
    public void DemoDaoFunction() {
        System.out.println(getClass()+" In the Account Dao");
    }
}
