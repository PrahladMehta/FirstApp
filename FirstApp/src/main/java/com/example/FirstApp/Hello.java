package com.example.FirstApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

//    @GetMapping("/student")
    public String hello(){
        return "Hello world, this is my first spring boot app";
    }

}
