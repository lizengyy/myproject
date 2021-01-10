package com.china.entity.admin;

import java.sql.Timestamp;

public class AdminEntity{

    private String id;
    private String user;
    private String pwd;
    private String name;
    private String part_id;
    private String role_id;
    private Integer state;
    private Timestamp createDate;
    private String creater;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartId() {
        return part_id;
    }

    public void setPartId(String partId) {
        this.part_id = partId;
    }

    public String getRoleId() {
        return role_id;
    }

    public void setRoleId(String roleId) {
        this.role_id = roleId;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

}
