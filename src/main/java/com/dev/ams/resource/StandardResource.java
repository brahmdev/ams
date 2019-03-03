package com.dev.ams.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/admin/users")
public class StandardResource {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public Optional<Users> getUser(@PathVariable String username) {
        return userRepository.findById(username);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Users saveOrUpdateUser(@RequestBody Users user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String username) {
        userRepository.deleteById(username);
    }
}
