package com.china.service.admin;

import com.china.entity.admin.AdminEntity;
import com.china.entity.admin.MenuEntity;

import java.util.Map;

public interface MenuService {

    Map queryIndexMenu(AdminEntity user) ;

    MenuEntity selectOne();

}
