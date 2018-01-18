package com.dituhui.saas.service.pathplan.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.binding.BinderAwareChannelResolver;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus; 
import org.springframework.messaging.support.GenericMessage;

@EnableBinding  
@RestController  
public class DynamicDestinationKafkaProducerController {  
  
  
    @Autowired  
    private BinderAwareChannelResolver resolver;  
  
    /** 
     * @param body   kafka消息内容 
     * @param target 目标topic 
     */  
    @RequestMapping(path = "/topics/{target}", method = {RequestMethod.GET,RequestMethod.POST}, consumes = "*/*")  
    @ResponseStatus(HttpStatus.ACCEPTED)  
    public void sendKafkaMessage(@RequestBody byte[] body, @PathVariable("target") String target) {  
    	System.out.println(111);
        sendMessage(body, target);  
    }  
  
  
//    private void sendMessage(String body, String target) {  
//        sendMessage(body.getBytes(), target);  
//    }  
//  
    private void sendMessage(byte[] body, String target) {  
        resolver.resolveDestination(target).send(new GenericMessage<>(body));  
    }  
  
  
} 
