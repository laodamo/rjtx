package com.cao.rjtx_homework6.dao;

import com.cao.rjtx_homework6.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    UserRepostory userRepostory;

    @Override
    public User insert(User user) {
        System.out.println(user.toString());
        User user1 = userRepostory.save(user);
        return user1;
    }

    @Override
    public User getUser(String id) {
        Optional<User> optional = userRepostory.findById(id);
        if(optional.isPresent()&&optional!=null){
            return optional.get();
        }
        return null;
    }

    @Override
    public List<User> getAllUser() {
        List<User> all = userRepostory.findAll();
        return all;
    }

}
