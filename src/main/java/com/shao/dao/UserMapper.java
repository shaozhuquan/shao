package com.shao.dao;

import com.shao.bean.User;
import org.springframework.stereotype.Repository;

/**
 * Created by shaozhuquan on 2018/9/18.
 */
@Repository
public interface UserMapper {

    void saveUser(User user);
}
