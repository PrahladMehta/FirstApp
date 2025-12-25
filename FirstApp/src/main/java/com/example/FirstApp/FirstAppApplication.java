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
	@Autowired
	RazorpayService razorpay;

// Constructure dependency injection
//	FirstAppApplication(RazorpayService razorpay){
//		this.razorpay=razorpay;
//	}

	@Override
	public void run(String... args) throws Exception {
		 razorpay.pay();
	}
}
