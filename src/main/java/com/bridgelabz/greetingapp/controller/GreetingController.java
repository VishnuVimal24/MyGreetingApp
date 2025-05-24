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
		
		// 🟩 UC3: Return greeting with first name and last name
		@GetMapping(params = {"firstName", "lastName"})
		public Greeting getGreetingWithFullName(@RequestParam String firstName,
		                                        @RequestParam String lastName) {
		    return greetingService.addGreeting(firstName, lastName);
		}
		
		// 🟩 UC4: Save greeting (handled implicitly in UC1–UC3 via service layer)

		// 🟩 UC5: Get greeting by ID
		@GetMapping("/{id}")
		public Optional<Greeting> getGreetingById(@PathVariable Long id) {
		    return greetingService.getGreetingById(id);
		}
		
		// 🟩 UC6: Get all greetings
		@GetMapping("/all")
		public List<Greeting> getAllGreetings() {
		    return greetingService.getAllGreetings();
		}

	
}
