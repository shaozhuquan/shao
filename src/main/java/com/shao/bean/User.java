package com.shao.bean;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by shaozhuquan on 2018/9/13.
 */
@Table(name = "user")
public class User {

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "age")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
