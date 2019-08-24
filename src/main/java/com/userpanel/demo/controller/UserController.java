package com.userpanel.demo.controller;

import com.userpanel.demo.model.User;
import com.userpanel.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/mongo/user")
public class UserController {

    @Autowired
    UserService userService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping
    public String create(@Valid @RequestBody List<User> user) {
        logger.debug("Saving user");
        userService.createUser(user);
        return "User created";
    }

    @GetMapping("/user")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("users", userService.getAllUser());
        return modelAndView;
    }


//    @GetMapping("/user")
//    public ModelAndView getAll() {
//        ModelAndView modelAndView = new ModelAndView("index");
//        modelAndView.addObject("users",userService.getAllUser());
//        return modelAndView;
//    }


    @GetMapping(value = "/getbyid/{user-id}")
    public Optional<User> getById(@PathVariable(value = "user-id") Integer id) {
        logger.debug("Getting user with id = {} ", id);
        return userService.findUserById(id);
    }

    @GetMapping(value = "/findOne")
    @ResponseBody
    public Optional<User> findOne(Integer id) {
        return userService.findUserById(id);
    }

    @PostMapping("/save")
    public String save(User user) {
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userService.createUser(userList);
        return "redirect:/";
    }

    @PutMapping(value = "/update/{user-id}")
    public String update(@PathVariable(value = "user-id") Integer id, @Valid @RequestBody User user) {
        logger.debug("Updating user with id = {}", id);
        user.setId(id);
        userService.updateUser(user);
        return "User with id = {} " + id + " updated";
    }

    @GetMapping(value = "/delete")
    public String delete(Integer id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }


//    @DeleteMapping(value = "/delete/{user-id}")
//    public String delete(@PathVariable(value = "user-id") Integer id) {
//        logger.debug("Deleting user with id = {}", id);
//        userService.deleteUserById(id);
//        return "User with id = {} " + id + " deleted";
//    }

}
