package com.apress.demo.springblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringblogApplication extends SpringBootServletInitializer {
    // Uncomment when you want to build a WAR file instead of JAR file
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(SpringblogApplication.class);
//    }


    public static void main(String[] args) {
        SpringApplication.run(SpringblogApplication.class, args);
    }

}
