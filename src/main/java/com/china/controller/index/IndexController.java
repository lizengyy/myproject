package com.china.controller.index;

import com.china.service.admin.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
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

    @RequestMapping("/index")
    public ModelAndView index() {
        Map<String, Object> data = new HashMap<>(2);
        data.put("name", "YiHui Freemarker");
        data.put("now", LocalDateTime.now().toString());
        return new ModelAndView("index", data);
    }

}
