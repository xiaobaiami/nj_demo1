package com.nj.intercept;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyIntercept implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("current_user") == null){
            System.out.println("lanjie " +request.getRequestURI());
            request.setAttribute("msg","请登陆");
            request.getRequestDispatcher("/").forward(request, response);
            return false;
        }
        return true;
    }
}
