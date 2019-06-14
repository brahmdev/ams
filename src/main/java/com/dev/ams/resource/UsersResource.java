package com.dev.ams.resource;

import com.dev.ams.model.Users;
import com.dev.ams.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/admin/users")
public class UsersResource {

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
        if (user.getStudentDetailses().iterator().hasNext()) {
            user.getStudentDetailses().iterator().next().setUsers(user);
        }

        if (user.getAuthoritieses().iterator().hasNext()) {
            user.getAuthoritieses().iterator().next().setUsers(user);
        }

        if (user.getParentDetailses().iterator().hasNext()) {
            user.getParentDetailses().iterator().next().setUsers(user);
        }
        return userRepository.save(user);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String username) {
        userRepository.deleteById(username);
    }
}
