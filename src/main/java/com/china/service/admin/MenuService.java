package com.china.service.admin;

import com.china.entity.admin.AdminEntity;
import com.china.entity.admin.MenuEntity;

import java.util.List;
import java.util.Map;

public interface MenuService {

    /**
     * 获取首页导航菜单数据
     * @param user
     * @return
     */
    Map queryIndexMenu(AdminEntity user);

    /**
     * 根据级别，类型，角色权限，获取菜单树数据
     * @param menulvl -1表示无限制
     * @param menuType -1表示无限制
     * @param roleId null或""表示无限制
     * @return
     */
    List<MenuEntity> getMenuTree(int menulvl, int menuType, String roleId);
}
