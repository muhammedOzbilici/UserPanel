package com.userpanel.demo.service.impl;

import com.userpanel.demo.converter.UserDtoToEntityConverter;
import com.userpanel.demo.converter.UserEntityToDtoConverter;
import com.userpanel.demo.dto.UserDto;
import com.userpanel.demo.entity.User;
import com.userpanel.demo.exception.UserNotFoundException;
import com.userpanel.demo.repository.UserRepository;
import com.userpanel.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserEntityToDtoConverter entityToDtoConverter;

    @Autowired
    UserDtoToEntityConverter dtoToEntityConverter;

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