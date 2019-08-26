package com.userpanel.demo.controller;

import com.userpanel.demo.dto.UserDto;
import com.userpanel.demo.entity.User;
import com.userpanel.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.util.Optional;


@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private static final int PAGE_NUMBER = 4;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("data", userService.findAll(PageRequest.of(page, PAGE_NUMBER)));
        model.addAttribute("currentPage", page);
        return "index";
    }

    @PostMapping("/save")
    public String save(User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(BigInteger id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @GetMapping("/findOne")
    @ResponseBody
    public Optional<User> findOne(BigInteger id) {
        return userService.findUserById(id);
    }

    @PostMapping("/edit")
    public String edit(User user) {
        userService.updateUser(user);
        return "redirect:/";
    }


}