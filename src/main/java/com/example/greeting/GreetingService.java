package com.example.greeting;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GreetingService {
	
	@Autowired
	private GreetingSearch repository;
	
	Random random = new Random();
	
	public String getGreeting(int exclusionId) {
		
		int randomId = getRandomId(exclusionId);
		Map<String, Object> map = repository.findById(randomId);
		
		Greeting greeting = new Greeting();
		greeting.setGreetingId(randomId);
		greeting.setGreeting((String)map.get("greeting"));
		greeting.setImagePath((String)map.get("imagePath"));
		
		ObjectMapper objectMapper = new ObjectMapper();
		String greetingJson = null;
		try {
			greetingJson = objectMapper.writeValueAsString(greeting);
		} catch (JsonProcessingException e) {

		}
		log.info(greetingJson);
		
		return greetingJson;
	}
	
	private int getRandomId(int exclusionId) {
		int randomId = exclusionId;
		while(randomId == exclusionId) {
			randomId = random.nextInt(3)+1;
		}
		
		return randomId;
	}
	
}
