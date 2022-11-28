package com.example.greeting;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greeting")
public class GreetingRestController{

	@Autowired
	private GreetingService service;
	
	Random random = new Random();
	
	@PostMapping("/search")
	public String PostDbRequest(@RequestParam(name="id", defaultValue = "0") int exclusionId) {
		String greeting = service.getGreeting(exclusionId);
		
		return greeting;
	}
	
}