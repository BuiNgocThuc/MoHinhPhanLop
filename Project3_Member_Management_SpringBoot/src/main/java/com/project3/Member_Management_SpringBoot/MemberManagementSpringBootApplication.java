package com.project3.Member_Management_SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.project3.Member_Management_SpringBoot")
public class MemberManagementSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberManagementSpringBootApplication.class, args);
	}

}
