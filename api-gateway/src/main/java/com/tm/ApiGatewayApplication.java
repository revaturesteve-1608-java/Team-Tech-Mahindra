package com.tm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@EnableFeignClients
@EnableZuulProxy
@EnableCircuitBreaker
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}	
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Ticket {
	private String firstName;
	private String lastName;
	
	public Ticket() {	// for JPA
	}
	public Ticket(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public String getName() {
		return this.firstName + " " + this.lastName;
	}
}

@FeignClient("service2")
interface TicketReader {
	
	@RequestMapping (method = RequestMethod.GET, value = "tickets")
	Resources<Ticket> read();
}

@RestController
@RequestMapping("tickets")
class TicketApiGateway {
	
	private final TicketReader ticketReader;
	
	@Autowired
	public TicketApiGateway(TicketReader ticketReader) {
		super();
		this.ticketReader = ticketReader;
	}

	public Collection<String> fallback() {
		return new ArrayList<>();
	}
	
	@HystrixCommand(fallbackMethod = "fallback")
	@RequestMapping(method = RequestMethod.GET, value = "names")
	public Collection<String> names() {
		return this.ticketReader
				.read()
				.getContent()
				.stream()
				.map(Ticket::getName)
				.collect(Collectors.toList());
	}
}
