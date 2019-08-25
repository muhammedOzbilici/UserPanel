package com.userpanel.demo.service;

import com.userpanel.demo.base.BaseMockitoTest;
import com.userpanel.demo.entity.User;
import com.userpanel.demo.repository.UserRepository;
import com.userpanel.demo.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigInteger;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class UserServiceImplTest extends BaseMockitoTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    public User entity;

    @Before
    public void before() {
        entity = new User();
        entity.setId(BigInteger.ONE);
        entity.setName("muhammed");
        entity.setSurname("özbilici");
        entity.setPhone("05354443322");
    }

    @Test
    public void it_should_return_one_user() {

        //given
        when(userRepository.findById(BigInteger.ONE)).thenReturn(java.util.Optional.ofNullable(entity));

        //when
        Optional<User> foundedUser = userService.findUserById(BigInteger.ONE);

        //then
        assertThat(foundedUser).isNotNull();
        assertThat(foundedUser.get().getName()).isNotNull();
        assertThat(foundedUser.get().getName()).isEqualTo(entity.getName());
        assertThat(foundedUser.get().getPhone()).isNotNull();
        assertThat(foundedUser.get().getPhone()).isEqualTo(entity.getPhone());
        assertThat(foundedUser.get().getSurname()).isNotNull();
        assertThat(foundedUser.get().getSurname()).isEqualTo(entity.getSurname());

    }

    @Test
    public void it_should_save_user() {

        //given
        User user = new User(BigInteger.ONE, "muhammed", "özbilici", "05354443322");

        //when
        userService.createUser(user);

        //then
        verify(userRepository).save(user);

    }

    @Test
    public void it_should_delete_user_by_id(){

        //given
        User user = new User(BigInteger.ONE, "muhammed", "özbilici", "05354443322");
        userService.createUser(user);

        //when
        userService.deleteUserById(user.getId());

        //then
        assertThat(userService.findUserById(user.getId())).isEmpty();

    }


}
