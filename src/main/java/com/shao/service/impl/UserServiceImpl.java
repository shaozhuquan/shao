package com.shao.service.impl;

import com.shao.bean.Email;
import com.shao.bean.User;
import com.shao.dao.UserMapper;
import com.shao.service.UserService;
import com.shao.util.BaseUtils;
import com.shao.util.email.DefaultMailOperation;
import com.shao.util.email.MailOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

    @Override
    public void updateAgeForId(Map<String,String> map) {
        userMapper.updateAgeForId(map);
    }

    @Override
    public void deleteUserForId(String id) {
        userMapper.deleteUserForId(id);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public void sendEmail(Email email) throws Exception {

        MailOperation mail = new DefaultMailOperation();
        //邮件服务器信息
        String serverAddress = email.getServerAddress();
        String sendAddress = email.getSendAddress();
        String[] acceptAddress = email.getAcceptAddress();
        String sendPort = email.getSendPort();
        String userName = email.getUserName();
        String password = email.getPassword();
        String subject = email.getSubject();
        String content = email.getContent();
        mail.doSendMail(userName,password,serverAddress,sendPort,sendAddress,acceptAddress,subject,content);

    }
}
