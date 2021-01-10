package com.china.entity.admin;

import com.china.entity.BaseEntity;

import java.util.List;

public class MenuEntity extends BaseEntity {

    private String menuId ;
    private String menuName ;
    private int menulevel ;
    private String menuParent ;
    private int menuType ;
    private String menuUrl ;
    private int menuSeq ;
    private String menuAttr1 ;
    private String menuAttr2 ;
    private String menuAttr3 ;

//    @TableField(exist = false)
    private List<MenuEntity> menuSecond;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenulevel() {
        return menulevel;
    }

    public void setMenulevel(int menulevel) {
        this.menulevel = menulevel;
    }

    public String getMenuParent() {
        return menuParent;
    }

    public void setMenuParent(String menuParent) {
        this.menuParent = menuParent;
    }

    public int getMenuType() {
        return menuType;
    }

    public void setMenuType(int menuType) {
        this.menuType = menuType;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public int getMenuSeq() {
        return menuSeq;
    }

    public void setMenuSeq(int menuSeq) {
        this.menuSeq = menuSeq;
    }

    public String getMenuAttr1() {
        return menuAttr1;
    }

    public void setMenuAttr1(String menuAttr1) {
        this.menuAttr1 = menuAttr1;
    }

    public String getMenuAttr2() {
        return menuAttr2;
    }

    public void setMenuAttr2(String menuAttr2) {
        this.menuAttr2 = menuAttr2;
    }

    public String getMenuAttr3() {
        return menuAttr3;
    }

    public void setMenuAttr3(String menuAttr3) {
        this.menuAttr3 = menuAttr3;
    }

    public List<MenuEntity> getMenuSecond() {
        return menuSecond;
    }

    public void setMenuSecond(List<MenuEntity> menuSecond) {
        this.menuSecond = menuSecond;
    }
}
