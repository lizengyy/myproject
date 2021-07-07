package com.china.entity.admin;

import java.util.List;

public class MenuTreeEntity {

    private MenuEntity menuParam;

    private List<MenuTreeEntity> childrenList;

    public MenuEntity getMenuParam() {
        return menuParam;
    }

    public void setMenuParam(MenuEntity menuParam) {
        this.menuParam = menuParam;
    }

    public List<MenuTreeEntity> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<MenuTreeEntity> childrenList) {
        this.childrenList = childrenList;
    }
}
