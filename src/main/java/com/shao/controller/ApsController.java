package com.shao.controller;

import com.shao.util.aps.apsUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shaozhuquan on 2018/11/7.
 */
@RestController
@RequestMapping(value = "aps")
public class ApsController {

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public Map<String,Object> test(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> result = new HashMap<>();
        String response_code;
        try{
            List<String> list = new ArrayList<>();
            list.add("12");
            String re = list.get(1);
            result.put("data","abc你们");
            response_code = "200_0001";
        }catch (Exception e){
            result = apsUtils.errorInfo(e);
            response_code = "400_0001";
        }
        apsUtils.setHeader(request,response,response_code);
        return result;
    }

}
