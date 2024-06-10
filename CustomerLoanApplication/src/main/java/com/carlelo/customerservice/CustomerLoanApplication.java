package com.carlelo.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CustomerLoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerLoanApplication.class, args);
	}
	@Bean
	public RestTemplate rs()
	{
		RestTemplate rt=new RestTemplate();
		return rt;
				
	}
	public RestTemplate rt()
	{
		RestTemplate rs=new RestTemplate();
		return rs;
	}


}
