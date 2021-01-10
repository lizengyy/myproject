package com.china.service.admin.impl;

import com.china.entity.admin.AdminEntity;
import com.china.entity.admin.MenuEntity;
import com.china.framework.constant.Constant;
import com.china.mapper.admin.MenuMapper;
import com.china.service.admin.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Map queryIndexMenu(AdminEntity user) {
        Map data = new HashMap();
        /*菜单数据*/
        List<MenuEntity> indexData = menuMapper.selectList(Constant.MENU_LVL_IDX, Constant.MENU_ROOT, -1);
        if(indexData.size()>0){
            MenuEntity mainMenu = indexData.get(0);
            List<MenuEntity> funOne = menuMapper.selectList(Constant.MENU_LVL_ONE, mainMenu.getMenuId(), -1);
            if(funOne.size()>0){
                for(MenuEntity me : funOne){
                    if(me.getMenuType()==Constant.MENU_TYPE_GUD){
                        List<MenuEntity> funSecond = menuMapper.selectList(Constant.MENU_LVL_ONE, mainMenu.getMenuId(), -1);
                        if(funSecond.size()>0){
//                            me.setMenuSecond(funSecond);
                        }
                    }
                }
            }
            data.put("MenuData", funOne);

            MenuEntity userMenu = indexData.get(3);
            List<MenuEntity> userSecond = menuMapper.selectList(Constant.MENU_LVL_ONE, userMenu.getMenuId(), -1);
            if(userSecond.size()>0){
//                userMenu.setMenuSecond(userSecond);
            }
            /*用户中心数据*/
            data.put("UserMenu", userMenu);

            /*用户指南*/
            data.put("HelpMenu", indexData.get(2));
        }
        return data;
    }

    public MenuEntity selectOne(){
        return menuMapper.selectOne();
    }

}
