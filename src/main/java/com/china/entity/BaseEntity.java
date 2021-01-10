package com.china.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class BaseEntity implements Serializable {

    private Integer state;
    private Timestamp crtDate;
    private String creater;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Timestamp getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(Timestamp crtDate) {
        this.crtDate = crtDate;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }
}
