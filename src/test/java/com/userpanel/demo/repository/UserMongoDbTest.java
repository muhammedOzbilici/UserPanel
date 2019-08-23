package com.userpanel.demo.repository;

import com.userpanel.demo.model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMongoDbTest {

    @Autowired
    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        User user1 = new User("ahmet", "1");

//        Assert.assertNull(user1.getId());
//        Assert.assertNull(user2.getId());
        this.userDao.save(user1);

        Assert.assertNotNull(user1.getId());
    }

    @Test
    public void testFetchData() {
        Optional<User> userA = userDao.findById(1);
        Assert.assertNotNull(userA);
        Assert.assertEquals("ahmet", userA.get().getName());

        Iterable<User> users = userDao.findAll();
        int count = 0;
        for (User u : users) {
            count++;
        }
        Assert.assertEquals(count, 2);
    }

//    @Test
//    public void testDataUpdate(){
//        Optional<User> userB = userDao.findById(2);
//        userB.get().setName("mustafa");
//        userDao.saveAll(userB);
//
//
//    }

    @After
    public void tearDown() throws Exception {
        this.userDao.deleteAll();
    }

}
