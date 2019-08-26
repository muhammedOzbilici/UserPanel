package com.userpanel.demo;

import com.userpanel.demo.entity.User;
import com.userpanel.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigInteger;

@SpringBootApplication
public class UserApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {

        SpringApplication.run(UserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User(BigInteger.valueOf(1L),"ahmet","kara","0(535)4443322"));
        userRepository.save(new User(BigInteger.valueOf(2L),"mehmet","beyaz","0(535)3334422"));
        userRepository.save(new User(BigInteger.valueOf(3L),"fatma","sarı","0(535)5658998"));
        userRepository.save(new User(BigInteger.valueOf(4L),"ayşe","kırmızı","0(535)4843322"));
        userRepository.save(new User(BigInteger.valueOf(5L),"hasan","eflatun","0(535)7443322"));
    }
}
