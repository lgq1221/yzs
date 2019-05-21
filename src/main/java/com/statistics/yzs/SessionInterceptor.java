package com.statistics.yzs;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @author Lgq
 * @Desc
 * @create 2019-01-22 16:40
 **/
public class SessionInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object o)throws Exception{
        //登陆不做拦截
        if(request.getRequestURI().equals("/user/login")||request.getRequestURI().equals("/user/login_view")){
            return true;
        }
        //验证session是否存在
        Object obj = request.getSession().getAttribute("session_user");
        if (obj == null){
            response.sendRedirect("/user/login_view");
            return false;
        }
        return true;
    }
}
