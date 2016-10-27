package com.tm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class Service1Application {

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}
}

@RestController
@RefreshScope
class MessageRestController {
	private final String value;
	
	@Autowired
	public MessageRestController(@Value("${message}") String value) {
		this.value = value;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/message")
	String readMessage() {
		return value;
	}
	
}
