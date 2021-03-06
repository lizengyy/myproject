package com.china.controller;

import com.china.utils.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 错误处理控制器
 * Liz 2020-12-1
 */
@Controller
public class MyErrorController implements ErrorController {

    private Logger log = LoggerFactory.getLogger(MyErrorController.class);

    private static final String ERROR_PATH = "/error";

    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @Autowired
    public MyErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    /**
     * 跳转掉线重登录管理页面
     */
    @RequestMapping(value = "error/unlogging")
    public String errorUnLogging(HttpServletRequest request, HttpServletResponse response) {
        return "error/unlogging";
    }

    /**
     * Web页面错误处理
     */
    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public String errorPageHandler(HttpServletRequest request, HttpServletResponse response) {
        int status = response.getStatus();
        switch (status) {
            case 403:
                log.info("禁止操作");
                return "error/403";
            case 404:
                log.info("资源不存在");
                return "error/404";
            case 415:
                log.info("HTTP接口请求格式异常！");
                return "error/415";
            case 500:
                log.info("未知异常");
                return "error/500";
        }
        return "error/500";
    }

    /**
     * 除Web页面外的错误处理，比如Json/XML等
     */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public ApiResponse errorApiHandler(HttpServletRequest request, final Exception ex, final WebRequest req) {
        log.error("程序异常", ex);
        Map<String, Object> attr = this.errorAttributes.getErrorAttributes(req, false);
        int status = getStatus(request);

        return ApiResponse.ofMessage(status, String.valueOf(attr.getOrDefault("message", "error")));
    }

    private int getStatus(HttpServletRequest request) {
        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (status != null) {
            return status;
        }

        return 500;
    }
}
