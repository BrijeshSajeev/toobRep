package com.example.springboot.aopDemo;

import com.example.springboot.aopDemo.dao.AccountDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao){
		return runner->{

			demoCreateAcc(accountDao);
		};

	}

	private void demoCreateAcc(AccountDao accountDao) {

		accountDao.DemoDaoFunction();

	}
}
