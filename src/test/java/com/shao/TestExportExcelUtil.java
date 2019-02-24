package com.shao;


import com.shao.bean.Student;
import com.shao.util.excel.ExportExcelUtil;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestExportExcelUtil {

    public static void main(String[] args) throws Exception{
        ExportExcelUtil<Student> util = new ExportExcelUtil<>();
        // 准备数据
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Student(111,"张三asdf","男"));
            list.add(new Student(111,"李四asd","男"));
            list.add(new Student(111,"王五","女"));
        }
        //String[] columnNames = { "ID", "姓名", "性别" };
        String[] columnNames = {"id","日期","型号","大通需求","其他需求","小计","大通需求","其他需求","小计","期初库存","计划生产","产线号","产能限制"};
        util.exportExcel("需求统计", columnNames, list, new FileOutputStream("E:/test.xls"), ExportExcelUtil.EXCEL_FILE_2003);
    }
}


