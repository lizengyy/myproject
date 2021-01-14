package com.china.controller.index;

import com.china.entity.admin.AdminEntity;
import com.china.service.admin.AdminService;
import com.china.service.admin.MenuService;
import com.china.utils.MapUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
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

    @Autowired
    MenuService menuService;

    @GetMapping(path = {"", "/", "/login", "/loginPage"})
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value="/reLogin", method= RequestMethod.POST)
    @ResponseBody
    public Map reLogin(HttpServletResponse response, @RequestParam Map param, HttpSession session) {
        Map<String, Object> data = new HashMap();
        String username = MapUtil.safeStr("userName", param);
        String password = MapUtil.safeStr("pwd", param);

        Map verifyMap = logVerify(username, password);
        String flag= MapUtil.safeStr("flag", verifyMap);

        data.put("flag", flag);
        if(flag.equals("1")){
            AdminEntity user = (AdminEntity)verifyMap.get("user");
            data.put("UserName",user.getName());
            session.setAttribute(user.getId(), user);
            Cookie cookie=new Cookie("UserTicket",user.getId());
            response.addCookie(cookie);
            log.info("用户"+username+"掉线重登录成功");
        }else{
            log.info(flag+"用户"+username+"登录失败");
        }
        return data;
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public ModelAndView login(HttpServletResponse response, @RequestParam Map param, HttpSession session) {
        Map<String, Object> data = new HashMap();
        String username = MapUtil.safeStr("userName", param);
        String password = MapUtil.safeStr("pwd", param);

        Map verifyMap = logVerify(username, password);
        String flag= MapUtil.safeStr("flag", verifyMap);

        if(flag.equals("1")){
            AdminEntity user = MapUtil.safeObj("user", AdminEntity.class, verifyMap);
            data = loadIndexData(user);
            data.put("UserName",user.getName());
            session.setAttribute(user.getId(), user);
            Cookie cookie=new Cookie("UserTicket",user.getId());
            response.addCookie(cookie);
            log.info("用户"+username+"登录成功转向首页");
            return new ModelAndView("index", data);
        }else{
            data.put("errMsg", flag);
            log.info(flag+"用户"+username+"登录失败");
            return new ModelAndView("login", data);
        }
    }

    @RequestMapping(value="/logout", method= RequestMethod.POST)
    @ResponseBody
    public String logout(HttpServletRequest request, HttpSession session) {
        try{
            String ticket = request.getAttribute("UserTicket")+"";
            /* TODO 这段逻辑后期需要修改，发请求注销sso侧的session,成功后再进行后续操作*/
            if(session.getAttribute(ticket)!=null && session.getAttribute(ticket) instanceof AdminEntity){
                AdminEntity user = (AdminEntity)request.getSession().getAttribute(ticket);
                session.removeAttribute(ticket);
                log.info("$$$$$$$$$$$$$用户"+user.getName()+"已登出");
            }
            /* TODO 这段逻辑后期需要修改，发请求注销sso侧的session,成功后再进行后续操作*/
            return "1";
        }catch (Exception e){
            return "0";
        }
    }

    private Map logVerify(String userName, String pwd){
        Map outMap = new HashMap();
        String isAdmin = "1";
        AdminEntity user = null;
        try{
            /* TODO 这段逻辑后期需要修改，对接sso系统，而非本地校验*/
            user = adminService.selectOneAdministrator(userName);
            if(user!=null) {
                log.info("$$$$$$$$$$$$$用户"+userName+"请求登录");
                log.info("用户输入密码：" + pwd );
                if (!pwd.equals(user.getPwd())) {
                    isAdmin = "密码不正确，何人冒充！";
                }else{
                    outMap.put("user", user);
                }
            }else{
                isAdmin = "账号不存在,你谁啊！";
            }
            /* TODO 这段逻辑后期需要修改，对接sso系统，而非本地校验*/
        }catch (Exception e){
            isAdmin = "未知异常，朕体欠安，稍后再来吧！";
        }
        outMap.put("flag", isAdmin);
        return outMap;
    }

    /**
     * 加载菜单数据
     */
    private Map loadIndexData(AdminEntity user){
        return menuService.queryIndexMenu(user);
    }

}
