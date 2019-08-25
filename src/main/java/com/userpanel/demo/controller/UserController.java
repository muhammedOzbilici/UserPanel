package com.userpanel.demo.controller;

import com.userpanel.demo.entity.User;
import com.userpanel.demo.repository.UserRepository;
import com.userpanel.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.Optional;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("data", userRepository.findAll(PageRequest.of(page, 4)));
        model.addAttribute("currentPage",page);
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

//    @RequestMapping(value = "/edit/{id}")
//    public String editUser(@PathVariable("id") BigInteger id, Model model) {
//        model.addAttribute("user", userService.findUserById(id));
//        return "redirect:/";
//    }

//    @RequestMapping(value = "save", method = RequestMethod.POST)
//    public String save(User user) {
//        userService.createUser(user);
//        return "redirect:/users";
//    }


}