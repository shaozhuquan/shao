package com.shao.bean;

import javax.persistence.Column;

/**
 * Created by shaozhuquan on 2018/9/26.
 */
public class Base {
    @Column(name = "creator")
    private String creator;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "editor")
    private String editor;

    @Column(name = "edit_time")
    private String editTime;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }
}
