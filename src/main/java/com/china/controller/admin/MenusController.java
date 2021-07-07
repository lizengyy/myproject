package com.china.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MenusController {

    Logger log = LoggerFactory.getLogger(MenusController.class);

    @RequestMapping("/menumanage")
    public ModelAndView adminInfo(HttpServletRequest request){
        Map data = new HashMap<>();
        return new ModelAndView("admin/menumanage", data);
    }

}
