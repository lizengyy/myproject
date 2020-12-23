package com.china.controller.index;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录控制器
 * Liz 2020-12-1
 */
@Controller
public class LoginController {

    Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    AdminService adminService;

    @GetMapping(path = {"", "/", "/login", "/loginPage"})
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
                log.info("用户输入密码：" + password );
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
                loadIndexData(data);
                data.put("UserName",user.getName());
                session.setAttribute(user.getId(), user);
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

    /**
     * 加载首页数据
     */
    private void loadIndexData(Map<String, Object> data){
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
    }

}
