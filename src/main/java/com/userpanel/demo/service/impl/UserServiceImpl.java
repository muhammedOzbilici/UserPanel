package com.userpanel.demo.service.impl;

import com.userpanel.demo.entity.User;
import com.userpanel.demo.repository.UserRepository;
import com.userpanel.demo.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findUserById(BigInteger id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUserById(BigInteger id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }


    @Override
    public Page<User> findAll(PageRequest page) {
        return userRepository.findAll(page);
    }

}