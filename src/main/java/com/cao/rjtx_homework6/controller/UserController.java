package com.cao.rjtx_homework6.controller;

import java.util.ArrayList;
import java.util.List;
import com.cao.rjtx_homework6.dao.UserDao;
import com.cao.rjtx_homework6.dao.UserDaoImpl;
import com.cao.rjtx_homework6.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {


    @Autowired
    UserDaoImpl userDao;

    @RequestMapping("/insert")
    public String insertUser(User user){
        User user1 = userDao.insert(user);
        return "redirect:all";
    }

    @RequestMapping("/all")
    public ModelAndView getAllUser(ModelAndView modelAndView) {
        modelAndView.addObject("all",userDao.getAllUser());
        modelAndView.setViewName("index");

        return modelAndView;
    }



}
