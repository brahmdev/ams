package com.dev.ams.resource;

import com.dev.ams.model.Authorities;
import com.dev.ams.model.ParentDetails;
import com.dev.ams.model.StudentDetails;
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
import java.util.Set;

@RestController
@RequestMapping("/api/v1/admin/users")
public class UsersResource {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/parent/{username}", method = RequestMethod.GET)
    public Optional<Users> getParentDetails(@PathVariable String username) {
        Optional<Users> studentUser = userRepository.findByUserName(username);
        Optional<Users> parentUser = null;
        Set<StudentDetails> studentDetails;
        Set<ParentDetails> parentDetails;

        if (studentUser.isPresent()) {
            studentDetails = userRepository.findStudentDetailsById(studentUser.get().getId());
            if (studentDetails.iterator().hasNext()) {
                String parentUserName = studentDetails.iterator().next().getParentsUsername();
                parentUser = userRepository.findByUserName(parentUserName);
                if (parentUser.isPresent()) {
                    parentDetails = userRepository.findParentDetailsById(parentUser.get().getId());
                    parentUser.get().setParentDetailses(parentDetails);
                }
            }
        }
        return parentUser;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{branchId}/{type}", method = RequestMethod.GET)
    public Iterable<Users> getUsersByType(@PathVariable Integer branchId, @PathVariable String type) {
        return userRepository.findByUsersByType(branchId, type);
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

    @RequestMapping(value = "/{username}/authorities", method = RequestMethod.GET)
    public Iterable<Authorities> getAuthorityByUserName(@PathVariable String username) {
        return userRepository.findAllAuthoritiesByUsername(username);
    }
}
