package com.china.controller.admin;

import com.china.entity.admin.AdminEntity;
import com.china.service.admin.AdminService;
import com.china.utils.MapUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
        data.put("state", user.getState());
        data.put("PartName", user.getPartId());
        data.put("Age", "xx年xx月xx天");
        return new ModelAndView("admin/admininfo", data);
    }

    @RequestMapping(value="/chgPwd", method= RequestMethod.POST)
    @ResponseBody
    public String chgPwd(HttpServletRequest request, @RequestParam Map param){
        String opwd = MapUtil.safeStr("opwd", param);
        String npwd = MapUtil.safeStr("npwd", param);
        String cpwd = MapUtil.safeStr("cpwd", param);
        String ticket = request.getAttribute("UserTicket")+"";
        AdminEntity user = (AdminEntity)request.getSession().getAttribute(ticket);
        if(user!=null && opwd.equals(user.getPwd())){
            adminService.updatePwd(user.getId(), npwd);
            return "1";
        }else{
            return "输入旧密码不正确!";
        }
    }

}
