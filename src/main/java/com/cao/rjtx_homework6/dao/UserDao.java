package com.cao.rjtx_homework6.dao;

import com.cao.rjtx_homework6.entity.User;
import java.util.List;
import org.springframework.stereotype.Repository;


public interface  UserDao {

    User insert(User user);
    User getUser(String id);
    List<User> getAllUser();


}
