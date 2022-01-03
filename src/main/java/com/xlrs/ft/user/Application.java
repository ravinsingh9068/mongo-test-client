package com.xlrs.ft.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.xlrs.ft.user.cofig.SSLConfig;

@SpringBootApplication
@PropertySource({ "classpath:messages.properties" })
@ComponentScan(basePackages = "com.xlrs.ft")
@EnableAutoConfiguration(exclude = { MongoAutoConfiguration.class })
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		SSLConfig.loadSSLProperties();
		SpringApplication.run(Application.class, args);
	}
}
