package com.userpanel.demo.controller;

import com.userpanel.demo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserPanelControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Before
    public void initTest(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void it_should_find_by_id(){

    }
}
