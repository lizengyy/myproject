package com.china.controller.admin;

import com.china.entity.admin.AdminEntity;
import com.china.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/test")
    @ResponseBody
    public AdminEntity selectOne(){
        return adminService.selectOneAdministrator("Liz");
    }

}
