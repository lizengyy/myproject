package com.china.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class BaseEntity implements Serializable {

    private Integer state;
    private Timestamp createDate;
    private String creater;

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
