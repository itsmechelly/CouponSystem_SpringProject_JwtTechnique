package com.couponsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.couponsystem.rest", "com.couponsystem.security"})
public class CouponSystemSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouponSystemSpringProjectApplication.class, args);
	}
}
