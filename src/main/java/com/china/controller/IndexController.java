package com.china.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/loginPage")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping(path = {"", "/", "/index"})
    public ModelAndView index() {
        Map<String, Object> data = new HashMap<>(2);
        data.put("name", "YiHui Freemarker");
        data.put("now", LocalDateTime.now().toString());
        return new ModelAndView("index", data);
    }

}
