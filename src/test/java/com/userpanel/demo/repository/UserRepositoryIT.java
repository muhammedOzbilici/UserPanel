package com.userpanel.demo.repository;

import com.userpanel.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UserRepositoryIT {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    UserRepository userRepository;

    @Test
    public void it_should_save_user_succesfully() {

        //arrange
        User savedUser = new User(BigInteger.ONE, "muhammed", "özbilici", "05354443322");
        mongoTemplate.insert(savedUser);

        //act
        Optional<User> expectedUser = userRepository.findById(BigInteger.ONE);

        //assert
        User user = expectedUser.get();
        assertThat(user).isEqualToComparingFieldByField(user);

    }

    @Test
    public void it_should_delete_user_by_id() {

        //arrange
        User savedUser = new User(BigInteger.ONE, "muhammed", "özbilici", "05354443322");
        userRepository.save(savedUser);

        //act
        userRepository.deleteById(savedUser.getId());

        //assert
        assertThat(userRepository.findById(savedUser.getId())).isEmpty();
    }

    @Test
    public void it_should_update_user() {

        //given
        User savedUser = new User(BigInteger.ONE, "muhammed", "özbilici", "05354443322");
        User updatedUser = savedUser;
        updatedUser.setPhone("05051120101");

        //when
        userRepository.save(savedUser);
        userRepository.save(updatedUser);

        //then
        assertThat(savedUser).isEqualToComparingFieldByField(updatedUser);

    }

    @Test
    public void it_should_find_all_user() {

        //given
        List<User> savedUserList = new ArrayList<>();
        savedUserList.add(new User(BigInteger.valueOf(1L), "user1", "surname1", "05354443320"));
        savedUserList.add(new User(BigInteger.valueOf(2L), "user2", "surname2", "05354443321"));
        savedUserList.add(new User(BigInteger.valueOf(3L), "user3", "surname3", "05354443322"));
        userRepository.saveAll(savedUserList);

        //when
        List<User> findedUserList = userRepository.findAll();

        //then
        assertThat(findedUserList).hasSameSizeAs(savedUserList);
    }

}
