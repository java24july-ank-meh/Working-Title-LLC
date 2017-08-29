package com.tcgtp.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
 
@SpringBootApplication
@ComponentScan("com.tcgtp.security")
@ComponentScan("com.tcgtp.controllers")
public class SpringBootWebApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
}