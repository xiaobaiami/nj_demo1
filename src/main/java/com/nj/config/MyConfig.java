package com.nj.config;

import com.nj.intercept.AdminIntercept;
import com.nj.intercept.MyIntercept;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@MapperScan("com.nj.model.mapper")
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/register.html").setViewName("register");
        registry.addViewController("/dashboard.html").setViewName("dashboard");
        registry.addViewController("/course.html").setViewName("course");
        registry.addViewController("/course_add.html").setViewName("course_add");
        registry.addViewController("/no_privilage.html").setViewName("no_privilage");
        registry.addViewController("/my_hw.html").setViewName("my_hw");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyIntercept()).addPathPatterns("/**")
                .excludePathPatterns("/bootstrap/**")
                .excludePathPatterns("/", "/index.html", "/register.html", "/user/login", "/user/register", "/register")
                .excludePathPatterns("/admin");

        registry.addInterceptor(new AdminIntercept()).addPathPatterns("/admin/**");
    }
}
