package com.shao.service;

import com.shao.bean.User;
import org.springframework.stereotype.Repository;

/**
 * Created by shaozhuquan on 2018/9/12.
 */
public interface UserService {

    User getUser();

    void saveUser(User user);
}
