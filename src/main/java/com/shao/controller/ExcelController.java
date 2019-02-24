package com.shao.controller;

import com.shao.bean.Student;
import com.shao.util.excel.ExportExcelUtil;
import com.shao.util.excel.ExportExcelWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaozhuquan on 2019/2/22.
 */
@Controller
@RequestMapping(value = "/test")
public class ExcelController {

    @GetMapping(value = "/get/excel")
    public void getExcel(HttpServletResponse response) throws Exception {
        // 准备数据
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Student(111,"张三asdf","男"));
            list.add(new Student(111,"李四asd","男"));
            list.add(new Student(111,"王五","女"));
        }
        //String[] columnNames = { "ID", "姓名", " 性别"};
        String[] columnNames = {"id","日期","型号","大通需求","其他需求","小计","大通需求","其他需求","小计","期初库存","计划生产","产线号","产能限制"};

        String fileName = "测试";
        ExportExcelWrapper<Student> util = new ExportExcelWrapper<Student>();
        util.exportExcel(fileName, fileName, columnNames, list, response, ExportExcelUtil.EXCEL_FILE_2003);
    }

}
