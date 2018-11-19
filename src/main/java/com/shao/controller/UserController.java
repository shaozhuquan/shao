package com.shao.controller;

import com.shao.bean.Email;
import com.shao.bean.User;
import com.shao.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shaozhuquan on 2018/9/18.
 */
@RestController
@Api(tags = "用户控制层")
@RequestMapping(value = "/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "保存用户信息")
    @RequestMapping(value = "/saveUser", method = {RequestMethod.POST})
    public Map<String,Object> saveUser(@RequestBody User user){
        boolean res = true;
        try{
            userService.saveUser(user);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("saveUser方法报错:"+e.getMessage());
            res = false;
        }
        Map<String,Object> result = new HashMap<>();
        result.put("res",res);
        return result;

    }


    @ApiOperation(value = "根据ID获取用户信息")
    @RequestMapping(value = "/getUser",method = {RequestMethod.GET})
    public Map<String,Object> getUser(@RequestParam String id) {
        boolean res = true;
        User user = new User();
        try {
            user = userService.getUser(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("getUser方法报错:"+e.getMessage());
            res = false;
        }
        Map<String,Object>result = new HashMap<>();
        result.put("res",res);
        result.put("user",user);
        return result;
    }

    @ApiOperation(value = "根据ID更新用户年龄")
    @RequestMapping(value = "/updateAge",method = RequestMethod.POST)
    public Map<String,Object>updateAge(@RequestBody Map<String,String>map) {
        boolean res = true;
        try {
            userService.updateAgeForId(map);
        } catch (Exception e){
            e.printStackTrace();
            logger.info("updateAge方法报错:"+e.getMessage());
            res = false;
        }
        Map<String,Object>result = new HashMap<>();
        result.put("res",res);
        return result;
    }

    @ApiOperation(value = "根据ID删除用户信息")
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public Map<String,Object>deleteUser(@RequestParam String id) {

        boolean res = true;
        try{
            userService.deleteUserForId(id);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("deleteUser方法报错:"+e.getMessage());
            res = false;
        }
        Map<String,Object> result = new HashMap<>();
        result.put("res",res);
        return result;
    }

    @ApiOperation(value = "获取表中所有数据")
    @RequestMapping(value = "/getAllUser",method = RequestMethod.POST)
    public Map<String,Object>getAllUser() {
        boolean res = true;
        List<User>list = new ArrayList<>();
        try{
            list = userService.getAllUser();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("getAllUser方法报错:"+e.getMessage());
            res = false;
        }
        Map<String,Object> result = new HashMap<>();
        result.put("res",res);
        result.put("list",list);
        return result;
    }

    @ApiOperation(value = "发送邮件")
    @RequestMapping(value = "/sendEmail",method = RequestMethod.POST)
    public Map<String,Object> sendEmail(@RequestBody Email email) {
        boolean res = true;
        try{
            userService.sendEmail(email);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("sendEmail方法报错:"+e.getMessage());
            res = false;
        }
        Map<String,Object> result = new HashMap<>();
        result.put("res",res);
        return result;
    }

}
