package com.springboot.learning.learnwebfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class LearnWebfilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnWebfilterApplication.class, args);
    }

}
