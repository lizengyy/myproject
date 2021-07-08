package com.china.service.admin.impl;

import com.china.entity.admin.AdminEntity;
import com.china.entity.admin.MenuEntity;
import com.china.framework.constant.Constant;
import com.china.mapper.admin.MenuMapper;
import com.china.service.admin.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List menuData = new ArrayList();
        List<MenuEntity> indexData = menuMapper.selectList(Constant.MENU_LVL_IDX, Constant.MENU_ROOT, -1);
        if(indexData.size()>0){
            MenuEntity mainMenu = indexData.get(0);
            List<MenuEntity> funOne = menuMapper.selectList(Constant.MENU_LVL_ONE, mainMenu.getMenuId(), -1);
            if(funOne.size()>0){
                int loopCount = funOne.size()%Constant.GUD_SIZE>0?funOne.size()/Constant.GUD_SIZE+1:funOne.size()/Constant.GUD_SIZE;
                for(int i=0; i<loopCount; i++){
                    List<MenuEntity> cellList = new ArrayList<MenuEntity>();
                    for(int j=0; j<Constant.GUD_SIZE; j++){
                        int index = i*Constant.GUD_SIZE+j;
                        if(index<funOne.size()){
                            MenuEntity me = funOne.get(i*Constant.GUD_SIZE+j);
                            if(me.getMenuType()==Constant.MENU_TYPE_GUD){
                                List<MenuEntity> funSecond = menuMapper.selectList(Constant.MENU_LVL_SECOND, me.getMenuId(), -1);
                                if(funSecond.size()>0){
                                    me.setMenuSecond(funSecond);
                                }
                            }
                            cellList.add(me);
                        }else{
                            break;
                        }
                    }
                    menuData.add(cellList);
                }
            }
            data.put("MenuData", menuData);

            MenuEntity userMenu = indexData.get(3);
            List<MenuEntity> userSecond = menuMapper.selectList(Constant.MENU_LVL_ONE, userMenu.getMenuId(), -1);
            if(userSecond.size()>0){
                userMenu.setMenuSecond(userSecond);
            }
            /*用户中心数据*/
            data.put("UserMenu", userMenu);

            /*用户指南*/
            data.put("HelpMenu", indexData.get(2));
        }
        return data;
    }

    @Override
    public List<MenuEntity> getMenuTree(int menulvl, int menuType, String roleId) {
        List<MenuEntity> rootData = menuMapper.selectList(Constant.MENU_LVL_IDX, Constant.MENU_ROOT, -1);
        if(rootData==null || rootData.size()<1){
            return new ArrayList<>();
        }
        queryTreeChild(rootData);
        return rootData;
    }

    private List<MenuEntity> queryTreeChild(List<MenuEntity> parentList) {
        if(parentList!=null || parentList.size()>0){
            for(MenuEntity MenuEntity : parentList){
                List<MenuEntity> data = menuMapper.selectList(-1, MenuEntity.getMenuId(), -1);
                if(data!=null && data.size()>0){
                    MenuEntity.setMenuSecond(queryTreeChild(data));
                }
            }
        }
        return parentList;
    }

}
