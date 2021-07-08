package com.china.controller.admin;

import com.china.service.admin.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MenusController {

    Logger log = LoggerFactory.getLogger(MenusController.class);

    @Autowired
    private MenuService menuService;

    @RequestMapping("/menumanage")
    public ModelAndView adminInfo(HttpServletRequest request){
        Map data = new HashMap<>();
        data.put("MenuTree", menuService.getMenuTree(-1, -1, ""));
        return new ModelAndView("admin/menumanage", data);
    }

}
