package com.dev.ams.service;

import com.dev.ams.model.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<Users> users;

    public List<Users> findAllUsers() {
        return users;
    }

    public Users findByName(String name) {
        for(Users user : users){
            if(user.getUsername().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }

    public void saveUser(Users user) {
        users.add(user);
    }

    public void updateUser(Users user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    public void deleteUserById(long id) {

        for (Iterator<Users> iterator = users.iterator(); iterator.hasNext(); ) {
            Users user = iterator.next();
        }
    }

    public boolean isUserExist(Users user) {
        return findByName(user.getUsername())!=null;
    }

    public void deleteAllUsers() {
        users.clear();
    }

}

