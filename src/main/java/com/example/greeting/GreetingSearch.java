package com.example.greeting;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GreetingSearch {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Map<String, Object> findById(int id){
		
		String query = "SELECT * FROM greetings WHERE id = ?";
		Map<String, Object> greeting = jdbcTemplate.queryForMap(query, id);
		return greeting;
	}

}
