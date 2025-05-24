package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GreetingService implements IGreetingService {

    @Autowired
    private GreetingRepository repository;

    @Override
    public Greeting addGreeting(String firstName, String lastName) {
        String message = "Hello " +
                (firstName != null ? firstName : "") +
                (lastName != null ? " " + lastName : "");
        if (message.trim().equals("Hello")) {
            message = "Hello World";
        }
        return repository.save(new Greeting(message.trim()));
    }

    @Override
    public Optional<Greeting> getGreetingById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return repository.findAll();
    }

    @Override
    public Greeting updateGreeting(Long id, String message) {
        Greeting greeting = repository.findById(id).orElseThrow();
        greeting.setMessage(message);
        return repository.save(greeting);
    }

    @Override
    public void deleteGreeting(Long id) {
        repository.deleteById(id);
    }
}
