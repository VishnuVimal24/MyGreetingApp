package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.model.Greeting;

import java.util.List;
import java.util.Optional;

public interface IGreetingService {
    Greeting addGreeting(String firstName, String lastName);
    Optional<Greeting> getGreetingById(Long id);
    List<Greeting> getAllGreetings();
    Greeting updateGreeting(Long id, String message);
    void deleteGreeting(Long id);
}
