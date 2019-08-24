package com.userpanel.demo.service.impl;

import com.userpanel.demo.model.User;
import com.userpanel.demo.repository.UserRepository;
import com.userpanel.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(List<User> users) {
        userRepository.saveAll(users);
    }

    @Override
    public Collection<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
