package main.java.controllers;


import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import main.java.models.Greeting;
import main.java.persistence.dao.userDAO;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @PostMapping("/greeting")
    public String greeting(@RequestParam(value="id", defaultValue="1") int id) {

        userDAO user = new userDAO();
        try{
            String response = user.getUser(id);
            return response;
        }
        catch(Exception ex) {
            return ex.toString();
        }

//        return new Greeting(counter.incrementAndGet(),
//                String.format(template, name));
    }
}