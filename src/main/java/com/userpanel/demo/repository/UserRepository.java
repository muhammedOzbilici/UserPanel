package com.userpanel.demo.repository;

import com.userpanel.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;


public interface UserRepository extends MongoRepository<User, BigInteger> {

}
