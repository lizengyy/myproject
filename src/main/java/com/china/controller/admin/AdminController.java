package com.china.controller.admin;

import com.china.entity.admin.AdminEntity;
import com.china.service.admin.AdminService;
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
public class AdminController {

    Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @RequestMapping("/admininfo")
    public ModelAndView adminInfo(HttpServletRequest request){
        String ticket = request.getAttribute("UserTicket")+"";
        AdminEntity user = (AdminEntity)request.getSession().getAttribute(ticket);
        Map data = new HashMap<>();
        data.put("UserInfo", user);
        return new ModelAndView("admin/admininfo", data);
    }

}
