package com.china.controller.index;

import com.china.entity.admin.AdminEntity;
import com.china.service.admin.AdminService;
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

/**
 * 首页控制器
 * Liz 2020-12-1
 */
@Controller
public class IndexController {

    Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    AdminService adminService;

    @Autowired
    MenuService menuService;

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        String ticket = request.getAttribute("UserTicket")+"";
        AdminEntity user = (AdminEntity)request.getSession().getAttribute(ticket);
        Map data = menuService.queryIndexMenu(user);
        return new ModelAndView("index", data);
    }

    @RequestMapping("/welcome")
    public ModelAndView welcome() {
        Map<String, Object> data = new HashMap();
        return new ModelAndView("welcome/welcome", data);
    }
}
