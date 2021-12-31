package com.springboot.learning.learnspringsecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.springboot.learning.learnspringsecurity.mapper")
public class LearnSpringsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringsecurityApplication.class, args);
	}

}
