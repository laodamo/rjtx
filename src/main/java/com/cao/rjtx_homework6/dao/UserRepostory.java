package com.cao.rjtx_homework6.dao;

import com.cao.rjtx_homework6.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepostory extends JpaRepository<User,String> {
}
