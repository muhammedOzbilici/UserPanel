package com.userpanel.demo.controller;

import com.userpanel.demo.model.User;
import com.userpanel.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/mongo/user")
public class UserController {

    @Autowired
    UserService userService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(value = "/create")
    public String create(@RequestBody List<User> user) {
        logger.debug("Saving user");
        userService.createUser(user);
        return "User created";
    }

    @GetMapping(value = "/getall")
    public Collection<User> getAll() {
        logger.debug("Getting all users");
        return userService.getAllUser();
    }

    @GetMapping(value = "/getbyid/{user-id}")
    public Optional<User> getById(@PathVariable(value = "user-id") int id) {
        logger.debug("Getting user with id = {} ", id);
        return userService.findUserById(id);
    }

    @PutMapping(value = "/update/{user-id}")
    public String update(@PathVariable(value = "user-id") int id, @RequestBody User user) {
        logger.debug("Updating user with id = {}", id);
        user.setId(id);
        userService.updateUser(user);
        return "User with id = " + id + " updated";
    }

    @DeleteMapping(value = "/delete/{user-id}")
    public String delete(@PathVariable(value = "user-id") int id) {
        logger.debug("Deleting user with id = {}", id);
        userService.deleteUserById(id);
        return "User with id = {}" + id + " deleted";
    }

}
