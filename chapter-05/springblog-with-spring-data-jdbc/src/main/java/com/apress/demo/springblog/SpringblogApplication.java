package com.apress.demo.springblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringblogApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringblogApplication.class, args);
    }
}
