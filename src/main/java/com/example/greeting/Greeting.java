package com.example.greeting;

import lombok.Data;

@Data
public class Greeting{
	private int greetingId;
	private String greeting;
	private String imagePath;
}