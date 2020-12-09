package com.china.controller;

import com.china.entity.admin.AdminEntity;
import com.china.service.admin.AdminService;
import com.china.utils.MapUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 主页和登录的控制器
 * Liz 2020-12-1
 */
@Controller
public class IndexController {

    Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    AdminService adminService;

    @GetMapping(path = {"", "/", "/loginPage"})
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public ModelAndView login(HttpServletResponse response, @RequestParam Map param, HttpSession session) {
        Map<String, Object> data = new HashMap();
        try{
            String username = MapUtil.safeStr("userName", param);
            String password = MapUtil.safeStr("pwd", param);

            /* TODO 这段逻辑后期需要修改，对接sso系统，而非本地校验*/
            AdminEntity user = adminService.selectOneAdministrator(username);
            int isAdmin = 0;
            if(user!=null) {
                log.info("$$$$$$$$$$$$$用户"+username+"请求登录");
                if (password.equals(user.getPwd())) {
                    isAdmin = 1;
                }else {
                    isAdmin = 2;
                }
            }else{
                isAdmin = 3;
            }
            /* TODO 这段逻辑后期需要修改，对接sso系统，而非本地校验*/

            if(isAdmin==1){
                data.put("name", user.getName());
                data.put("now", LocalDateTime.now().toString());
                session.setAttribute(user.getId(), data);
                Cookie cookie=new Cookie("UserTicket",user.getId());
                response.addCookie(cookie);
                log.info("用户"+username+"登录成功转向首页");
                return new ModelAndView("index", data);
            }else if(isAdmin==2){
                data.put("errMsg", "密码不正确，何人冒充！");
                log.info("密码错误，用户"+username+"登录失败");
                return new ModelAndView("login", data);
            }else if(isAdmin==3){
                data.put("errMsg", "账号不存在,你谁啊！");
                log.info("不存在的用户"+username+"登录失败");
                return new ModelAndView("login", data);
            }else{
                data.put("errMsg", "未知异常，朕体欠安，稍后再来吧！");
                log.info("未知异常，用户"+username+"登录失败");
                return new ModelAndView("login", data);
            }
        }catch (Exception e){
            log.error("登录程序异常！", e);
            data.put("errMsg", "未知异常！");
            return new ModelAndView("login", data);
        }
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        Map<String, Object> data = new HashMap<>(2);
        data.put("name", "YiHui Freemarker");
        data.put("now", LocalDateTime.now().toString());
        return new ModelAndView("index", data);
    }

}
