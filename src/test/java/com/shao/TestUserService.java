package com.shao;

import com.shao.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



/**
 * Created by shaozhuquan on 2018/9/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    public void testGetName(){
        System.out.println(userService.getUser().getName());
        //assertNotNull(userService);
    }

}
