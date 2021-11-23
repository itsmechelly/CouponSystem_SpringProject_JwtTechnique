package com.couponsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.couponsystem.filters.TokenFilter;
import com.couponsystem.security.JwtUtil;

@SpringBootApplication
@EnableTransactionManagement
public class CouponSystemSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouponSystemSpringProjectApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<TokenFilter> tokenFilterRegistration(JwtUtil jwtUtil){
		FilterRegistrationBean<TokenFilter> filterRegistrationBean = new FilterRegistrationBean<TokenFilter>();
		TokenFilter tokenFilter = new TokenFilter(jwtUtil);
		filterRegistrationBean.setFilter(tokenFilter);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}
}