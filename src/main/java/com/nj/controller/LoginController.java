package com.nj.controller;

import com.nj.model.User;
import com.nj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/user/login")
    public String login(String email, String password, HttpServletRequest request) {
        User login = userService.login(email, password);
        if (login != null) {
            request.getSession().setAttribute("current_user", email);
            request.getSession().setAttribute("u_id", login.getU_id());
            request.getSession().setAttribute("u_level", login.getType());
            return "redirect:/dashboard.html";
        }
        request.setAttribute("msg", "账号密码错误");
        return "login";
    }

    @PostMapping("/user/register")
    public String register(String email, String password, HttpServletRequest request) {
        boolean register = userService.register(email, password, 1);
        if (register) {
            return "redirect:/index.html";
        } else {
            request.setAttribute("msg", "用户已经存在");
            return "register";
        }
    }

    @GetMapping("/user/logOut")
    public String logOut(HttpServletRequest request) {
        request.getSession().removeAttribute("current_user");
        return "redirect:/index.html";
    }
}
