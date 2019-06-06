package com.dev.ams.resource;

import com.dev.ams.model.Users;
import com.dev.ams.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/login")
public class AuthResource {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public Optional<Users> login(Authentication authentication) {
        System.out.println(authentication.getCredentials() + " : " + authentication.getPrincipal());
        return userRepository.findByUserName(authentication.getName());
    }
}
