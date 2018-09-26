package com.shao.service.impl;

import com.shao.bean.User;
import com.shao.dao.UserMapper;
import com.shao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by shaozhuquan on 2018/9/12.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(){
        User user = new User();
        user.setName("shao");
        user.setSex("男");
        user.setAge(20);
        return user;
    }

    @Override
    public void saveUser(User user){
        userMapper.saveUser(user);
    }
}
