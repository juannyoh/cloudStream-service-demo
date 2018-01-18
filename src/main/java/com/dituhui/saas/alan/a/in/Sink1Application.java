package com.dituhui.saas.alan.a.in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = {"com.dituhui.saas.websocket","com.dituhui.saas.alan.a.in" })
public class Sink1Application {
	
	public static void main(String[] args) {
		String[] args2 = new String[]{"--server.port=8801","--spring.profiles.active=ain1"};
		SpringApplication.run(Sink1Application.class, args2);

	}

}
