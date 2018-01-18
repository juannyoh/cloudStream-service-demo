package com.dituhui.saas.alan.a.in;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.dituhui.saas.websocket.LogCacheUtils;

@EnableBinding(Sink.class)
public class MsgSink {

	@StreamListener(Sink.INPUT)
	public void messageSink(Object payload) {
		LogCacheUtils.put(payload.toString());
		System.out.println("Received: " + payload);
		
	}
}
