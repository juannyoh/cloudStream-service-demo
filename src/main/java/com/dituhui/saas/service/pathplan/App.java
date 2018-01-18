package com.dituhui.saas.service.pathplan;

import java.util.concurrent.CountDownLatch;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
	    @Bean
	    public CountDownLatch closeLatch() {
	        return new CountDownLatch(1);
	    }

	    public static void main(String[] args) throws InterruptedException {
	    	String[] args2 = new String[]{"--spring.profiles.active=dev"};
	        ApplicationContext ctx = new SpringApplicationBuilder().sources(App.class).web(true).run(args2);
	        CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
	        closeLatch.await();
	    }
}

