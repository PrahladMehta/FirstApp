package com.example.FirstApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FirstAppApplication.class, args);
	}

//  Field Dependency
//	@Autowired
	Payment payment;

// Constructure dependency injection
	FirstAppApplication(Payment payService){
		this.payment=payService;
	}

	@Override
	public void run(String... args) throws Exception {
		 payment.pay();
	}
}
