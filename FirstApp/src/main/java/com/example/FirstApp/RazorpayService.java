package com.example.FirstApp;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "payment.provider",havingValue="razorpay")
public class RazorpayService implements Payment {

    public void pay(){
        System.out.println("Razorpay payment ");
    }
}
