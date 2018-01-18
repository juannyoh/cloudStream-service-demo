package com.dituhui.saas.alan.a.out;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dituhui.saas.websocket.MyEndpointConfigure;

//@EnableAutoConfiguration
@SpringBootApplication
//@ComponentScan(basePackages = {"com.dituhui.saas.websocket","com.dituhui.saas.alan.a.out" })
@RestController
public class SourceApplication {
	
	@Autowired
	private SendService service;
	
	
	static String[] messages={"001,001-aa","001,001-bb","002,002-bb","002,002-cc"};
	
	 @Bean
    public MyEndpointConfigure newConfigure()
    {
        return new MyEndpointConfigure();
    }
	
	@RequestMapping(value = "/send/{msg}", method = RequestMethod.GET)
	public String send(@PathVariable("msg") String msg){
		service.sendMessage(msg);
		return "ok";
	}

	public static void main(String[] args) {

		String[] args2 = new String[]{"--server.port=8800","--spring.profiles.active=aout"};
		ApplicationContext ctx=SpringApplication.run(SourceApplication.class, args2);
		
		SendService service2=ctx.getBean(SendService.class);
		
		while (true){
			int index=RandomUtils.nextInt(1, 11);
			String message="00"+index+","+"00"+index+"-"+RandomStringUtils.randomAlphanumeric(6);
			service2.sendMessage(message);
			System.out.println(message);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
