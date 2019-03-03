package com.dev.ams.service;

import com.dev.ams.model.Users;

import java.util.List;

public interface UserService {

    Users findByName(String name);

    void saveUser(Users user);

    void updateUser(Users user);

    void deleteUserById(long id);

    List<Users> findAllUsers();

    void deleteAllUsers();

    public boolean isUserExist(Users user);
}
