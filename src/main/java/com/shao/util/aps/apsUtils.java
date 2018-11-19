package com.shao.util.aps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shaozhuquan on 2018/11/7.
 */
public class apsUtils {

    public static void setHeader(HttpServletRequest request,HttpServletResponse response, String response_code){
        response.setHeader("transc_id",request.getHeader("transc_id"));
        response.setHeader("transc_sn",request.getHeader("transc_sn"));
        response.setHeader("send_time",request.getHeader("send_time"));
        response.setHeader("due_time",request.getHeader("due_time"));
        response.setHeader("requestor",request.getHeader("requestor"));

        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        response.setHeader("response_time",dateFormat.format(date));
        response.setHeader("response_code",response_code);
    }

    public static Map<String,Object> errorInfo(Exception e){
        Map<String,Object> errorMap = new HashMap<>();
        errorMap.put("error_rawdata",e.getClass().getName());
        errorMap.put("error_info",e.getMessage());
        errorMap.put("error_code","E1011");
        errorMap.put("error_level","2");
        errorMap.put("recommendation","索引越界");
        return errorMap;
    }
}
