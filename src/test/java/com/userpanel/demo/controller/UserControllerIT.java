package com.userpanel.demo.controller;

import com.userpanel.demo.base.BaseIT;
import com.userpanel.demo.entity.User;
import com.userpanel.demo.service.UserService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class UserControllerIT extends BaseIT {

    @MockBean
    private UserService userService;

    @Captor
    private ArgumentCaptor<User> userCaptor;

    @Test
    public void it_should_save_user() throws Exception {

        //given
        User user = new User(BigInteger.ONE, "muhammed", "özbilici", "05354443322");

        //when
        ResultActions expectedResult = mockMvc.perform(post("/save?id=1&" +
                "name=muhammed&surname=özbilici&phone=05354443322")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andDo(print());

        //then
        verify(userService).createUser(userCaptor.capture());
        User expectedUser = userCaptor.getValue();
        assertThat(expectedUser).isEqualToComparingFieldByField(user);
        expectedResult.andExpect(status().is3xxRedirection());

    }

    @Test
    public void it_should_find_user_by_id() throws Exception {

        //given
        User user = new User(BigInteger.ONE, "muhammed", "özbilici", "05354443322");
        given(userService.findUserById(BigInteger.ONE)).willReturn(Optional.of(user));

        //when
        ResultActions expectedResult = mockMvc.perform(get("/findOne?id=" + BigInteger.ONE)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andDo(print());

        //then
        expectedResult.andExpect(status().is2xxSuccessful());
        expectedResult.andExpect(jsonPath("$.id").value(1));
        expectedResult.andExpect(jsonPath("$.name").value("muhammed"));
        expectedResult.andExpect(jsonPath("$.surname").value("özbilici"));
        expectedResult.andExpect(jsonPath("$.phone").value("05354443322"));
    }

    @Test
    public void it_should_delete_user_by_id() throws Exception {

        //given
        User user = new User(BigInteger.ONE, "muhammed", "özbilici", "05557212152");
        given(userService.findUserById(BigInteger.ONE)).willReturn(Optional.of(user));

        //when
        ResultActions expectedResult = mockMvc.perform(get("/delete?id=1&" + BigInteger.ONE)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andDo(print());


        //then
        verify(userService).deleteUserById(BigInteger.ONE);
        expectedResult.andExpect(status().is3xxRedirection());

    }

    @Test
    public void it_should_update_user_by_id() throws Exception {

        //given
        User savedUser = new User(BigInteger.ONE, "muhammed", "özbilici", "05557212152");
        userService.createUser(savedUser);
        given(userService.findUserById(BigInteger.ONE)).willReturn(Optional.of(savedUser));

        //when
        ResultActions expectedResult = mockMvc.perform(post("/edit?id=1&" +
                "name=muhammed&surname=özbilici&phone=05051223344")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andDo(print());


        //then

        verify(userService).updateUser(userCaptor.capture());
        User expectedUser = userCaptor.getValue();
        assertThat(expectedUser.getPhone()).isEqualTo("05051223344");
        expectedResult.andExpect(status().is3xxRedirection());

    }

}
