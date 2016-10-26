package com.revature.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SubjectCtrl {

	@Autowired
	DiscoveryClient client;
	
	@RequestMapping("/sentence")
	public @ResponseBody String getSentence() {
		return 
				getWord("LAB-4-SENTENCE");
	}

	public String getWord(String service) {
		List<ServiceInstance> list = client.getInstances(service);
		if (list != null && list.size() > 0 ) {
			System.out.println("-----------------THIS: " + list.size() + ":-------------------------------");
			URI uri = list.get(0).getUri();
			if (uri !=null ) {
				return (new RestTemplate()).getForObject(uri,String.class);
			}
		}
		return null;
	}
}
