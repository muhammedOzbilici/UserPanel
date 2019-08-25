package com.userpanel.demo;

import com.userpanel.demo.entity.User;
import com.userpanel.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigInteger;

@SpringBootApplication
public class UserPanel implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {

        SpringApplication.run(UserPanel.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User(BigInteger.valueOf(1L),"ahmet","kara","05354443322"));
        userRepository.save(new User(BigInteger.valueOf(2L),"mehnet","beyaz","05353334422"));
        userRepository.save(new User(BigInteger.valueOf(3L),"fatma","sarı","05355658998"));
        userRepository.save(new User(BigInteger.valueOf(4L),"ayşe","kırmızı","05354843322"));
        userRepository.save(new User(BigInteger.valueOf(5L),"hasan","eflatun","05357443322"));
        userRepository.save(new User(BigInteger.valueOf(6L),"hacer","pempe","05334443322"));
        userRepository.save(new User(BigInteger.valueOf(7L),"mustafa","siyah","05320443322"));
        userRepository.save(new User(BigInteger.valueOf(8L),"zeynep","mor","05314443922"));
        userRepository.save(new User(BigInteger.valueOf(9L),"ali","lacivert","05304463322"));
    }
}
