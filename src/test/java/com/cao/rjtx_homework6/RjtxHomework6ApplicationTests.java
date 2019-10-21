package com.cao.rjtx_homework6;

import com.cao.rjtx_homework6.dao.UserDao;
import com.cao.rjtx_homework6.dao.UserRepostory;
import com.cao.rjtx_homework6.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RjtxHomework6ApplicationTests {

    @Autowired
    UserRepostory userRepostory;
    @Autowired
    UserDao userDao;

    @Test
    public void contextLoads() {
        User user =userDao.getUser("111");
        System.out.println(user);

    }

}
