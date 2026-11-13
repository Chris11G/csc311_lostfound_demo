package edu.farmingdale.csc311.lostfound;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final String greeting;

    public HelloController(@Value("${campus.greeting}") String greeting) {
        this.greeting = greeting;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "student") String name) {
        return greeting + ", " + name + "!";
    }
}
