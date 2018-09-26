package com.shao.service.impl;

import com.shao.bean.User;
import com.shao.dao.UserMapper;
import com.shao.service.UserService;
import com.shao.util.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.rmi.CORBA.Util;
import java.util.UUID;

/**
 * Created by shaozhuquan on 2018/9/12.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String id){

        return userMapper.getUser(id);
    }

    @Override
    public void saveUser(User user){
        user.setId(BaseUtils.getUUID());
        user.setCreateTime(BaseUtils.getCurrentTime());
        user.setEditTime(BaseUtils.getCurrentTime());
        userMapper.saveUser(user);
    }
}
