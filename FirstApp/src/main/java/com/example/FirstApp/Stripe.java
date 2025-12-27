package com.example.FirstApp;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="payment.provider",havingValue="stripe")
public class Stripe implements Payment {

    public  void pay(){
         System.out.print("Stripe payment");
    }

}
