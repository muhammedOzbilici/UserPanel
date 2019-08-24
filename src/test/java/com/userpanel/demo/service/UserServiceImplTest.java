package com.userpanel.demo.service;

import com.userpanel.demo.model.User;
import com.userpanel.demo.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;


    @Test
    public void it_should_create_user() {
        List<User> userList = new ArrayList<>();
//        User user = new User("ahmet", "1");
//        User user2 = new User("mehmet", "2");
//        userList.add(user);
//        userService.createUser(userList);
//        Assert.assertEquals(userList, userService.getAllUser());

    }


}
