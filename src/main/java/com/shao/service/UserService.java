package com.shao.service;

import com.shao.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by shaozhuquan on 2018/9/12.
 */
public interface UserService {

    User getUser(String id);

    void saveUser(User user);

    void updateAgeForId(Map<String,String> map);

    void deleteUserForId(String id);

    List<User> getAllUser();
}
