package com.china.controller.index;

import com.china.service.admin.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页控制器
 * Liz 2020-12-1
 */
@Controller
public class IndexController {

    Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    AdminService adminService;

    @RequestMapping("/index")
    public ModelAndView index() {
        Map<String, Object> data = new HashMap();
        /*菜单数据*/
        List MenuData = new ArrayList();
        for(int n=0; n<2; n++){
            List MenuDataOne = new ArrayList();
            for(int i=0; i<5; ++i){
                int a = n==0 ? i : i+1;
                Map cell = new HashMap();
                cell.put("MenuId", i);
                if(n==0 && i==0){
                    cell.put("MenuName", "主界面");
                }else{
                    cell.put("MenuName", "模块"+a);
                    List MenuDataSecond = new ArrayList();
                    for(int j=0; j<5; j++){
                        Map cellSecond = new HashMap();
                        cellSecond.put("MenuId", i+"_"+j);
                        cellSecond.put("MenuName", "功能"+(j+1));
                        MenuDataSecond.add(cellSecond);
                    }
                    cell.put("MenuSecond", MenuDataSecond);
                }
                MenuDataOne.add(cell);
            }
            MenuData.add(MenuDataOne);
        }
        data.put("MenuData", MenuData);

        /*用户中心数据*/
        Map cell = new HashMap();
        cell.put("MenuId", "999");
        cell.put("MenuName", "个人中心");
        List MenuDataSecond = new ArrayList();
        for(int j=0; j<5; j++){
            Map cellSecond = new HashMap();
            cellSecond.put("MenuId", j);
            cellSecond.put("MenuName", "功能"+(j+1));
            MenuDataSecond.add(cellSecond);
        }
        cell.put("MenuSecond", MenuDataSecond);
        data.put("UserMenu", cell);

        /*用户指南*/
        Map helpMap = new HashMap();
        helpMap.put("MenuId", "9999");
        helpMap.put("MenuName", "用户指南");
        data.put("HelpMenu", helpMap);
        return new ModelAndView("index", data);
    }

    @RequestMapping("/welcome")
    public ModelAndView welcome() {
        Map<String, Object> data = new HashMap();
        return new ModelAndView("welcome/welcome", data);
    }
}
