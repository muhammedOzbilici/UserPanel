package com.userpanel.demo.repository;

import com.userpanel.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, Integer> {

}
