package com.example.greeting;

import java.util.Map;

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
	
	public String getGreeting(int id) {
		Map<String, Object> map = repository.findById(id);
		
		Greeting greeting = new Greeting();
		greeting.setGreetingId(id);
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
	
}
