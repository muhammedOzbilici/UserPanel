package com.userpanel.demo.service;

import com.userpanel.demo.entity.User;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {

    void createUser(User user);

    List<User> getAllUser();

    Optional<User> findUserById(BigInteger id);

    void deleteUserById(BigInteger id);

    void updateUser(User user);

    List<User> findAll();
}