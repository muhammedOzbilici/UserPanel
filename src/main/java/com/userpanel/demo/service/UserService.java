package com.userpanel.demo.service;

import com.userpanel.demo.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {

    void createUser(List<User> users);

    Collection<User> getAllUser();

    Optional<User> findUserById(int id);

    void deleteUserById(int id);

    void updateUser(User user);
}
