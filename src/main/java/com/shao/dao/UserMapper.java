package com.shao.dao;

import com.shao.bean.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by shaozhuquan on 2018/9/18.
 */
@Repository
public interface UserMapper {

    void saveUser(User user);

    User getUser(String id);

    void updateAgeForId(Map<String,String> map);

    void deleteUserForId(String id);
}
