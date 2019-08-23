package com.userpanel.demo.service.impl;

import com.userpanel.demo.model.User;
import com.userpanel.demo.repository.UserDao;
import com.userpanel.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void createUser(List<User> users) {
        userDao.saveAll(users);
    }

    @Override
    public Collection<User> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findUserById(int id) {
        return userDao.findById(id);
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.save(user);
    }
}
