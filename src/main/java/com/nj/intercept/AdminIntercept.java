package com.nj.intercept;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminIntercept implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object u_level = request.getSession().getAttribute("u_level");
        if ("0".equalsIgnoreCase(String.valueOf(u_level))) {
            return true;
        }
        request.getRequestDispatcher("/no_privilage.html").forward(request, response);
        return false;
    }
}
