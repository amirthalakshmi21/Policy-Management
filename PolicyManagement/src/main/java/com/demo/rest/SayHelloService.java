package com.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SayHelloService {

	@RequestMapping("/sayHello")
	public String sayHello() {
		return "Hello Amirtha ";
	}
	
}
