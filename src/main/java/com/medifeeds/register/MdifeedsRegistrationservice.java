package com.medifeeds.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MdifeedsRegistrationservice {

	
	public static void main(String[] args) {
		SpringApplication.run(MdifeedsRegistrationservice.class, args);

	}

}
