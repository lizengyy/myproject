package com.china.framework.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * Liz 2020-12-1
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    Logger log = LoggerFactory.getLogger(LoginHandlerInterceptor.class);

    /**
     * 登录拦截的判断逻辑核心
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，
     * SpringMVC中的Interceptor拦截器是链式的，可以同时存在 多个Interceptor，
     * 然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在
     * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，
     * 这种中断方式是令preHandle的返回值为false，当preHandle的返回值为false的时候整个请求就结束了。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*这一段代码需要向sso单点登录系统发送请求来验证用户是否有身份凭证(目前方案凭证放在前端请求的cookie里)，
        没有或者凭证无效就要转向登录页面*/
        return true;
        /*
        try{
            String ticket = "";
            boolean isLogin = false;
            Cookie[] cookies = request.getCookies();
            if(null!=cookies && cookies.length>0){
                for(Cookie cookie : cookies){
                    if(cookie.getName().equals("UserTicket")){
                        ticket = cookie.getValue();
                    }
                }
            }
            if(!StringUtils.isEmpty(ticket)){
                Object user = request.getSession().getAttribute(ticket);
                if(null!=user && user instanceof Map){
                    isLogin = true;
                }else{
                    // TODO 向sso发送验证请求，如果通过才把isLogin设置成 true
                }
            }
            if(isLogin){
                return true;
            }else{
                log.info("<<<framework>>>用户凭证校验不通过，转向登录页面!");
                response.sendRedirect("/loginPage");
                return false;
            }
        }catch (Exception e){
            log.error("<<<framework>>>登录校验发生异常!", e);
            response.sendRedirect("/loginPage");
            return false;
        }
        */
    }

    /**
     * 登录拦截的请求发送后-视图渲染前处理
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。
     * postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之后，
     * 也就是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，
     * 也就是说在这个方法中你可以对ModelAndView进行操作。这个方法的链式结构跟正常访问的方向是相反的，
     * 也就是说先声明的Interceptor拦截器该方法反而会后调用，这跟Struts2里面的拦截器的执行过程有点像，
     * 只是Struts2里面的intercept方法中要手动的调用ActionInvocation的invoke方法，
     * Struts2中调用ActionInvocation的invoke方法就是调用下一个Interceptor或者是调用action，
     * 然后要在Interceptor之前调用的内容都写在调用invoke之前，要在Interceptor之后调用的内容都写在调用invoke方法之后。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        /*暂时没有设计任何业务*/
    }

    /**
     * 登录拦截的视图渲染后处理
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。
     * 该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，这个方法的主要作用是用于清理资源的，
     * 当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        /*暂时没有设计任何业务*/
    }
}
