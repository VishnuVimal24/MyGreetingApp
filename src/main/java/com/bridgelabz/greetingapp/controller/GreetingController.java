package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

	@Autowired
	private IGreetingService greetingService;

	// 🟩 UC1: Return default greeting ("Hello World")
	@GetMapping
	public Greeting getDefaultGreeting() {
	    return greetingService.addGreeting(null, null);
	}
	
	// 🟩 UC2: Return greeting with first name
		@GetMapping(params = "firstName")
		public Greeting getGreetingWithFirstName(@RequestParam String firstName) {
		    return greetingService.addGreeting(firstName, null);
		}

	
}
