package com.userpanel.demo.service;

import com.userpanel.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface UserService {

    void createUser(User user);

    Optional<User> findUserById(BigInteger id);

    void deleteUserById(BigInteger id);

    void updateUser(User user);

    Page<User> findAll(PageRequest pageRequest);
}