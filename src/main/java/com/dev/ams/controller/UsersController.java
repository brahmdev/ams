package com.dev.ams.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @GetMapping("/{username}")
    public String getUser(@PathVariable String username) {
        return "Greetings from Spring Boot!" + username;
    }

}
