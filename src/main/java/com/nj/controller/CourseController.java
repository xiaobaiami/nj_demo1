package com.nj.controller;

import com.nj.model.Course;
import com.nj.service.CourseService;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class CourseController {


    @Autowired
    CourseService courseService;

    @GetMapping("/course/list")
    @ResponseBody
    public List<Course> coures_list(String year, HttpServletRequest request) {
        List<Course> allCourses = courseService.findAllCourses(year == null ? "all" : year);
//        request.setAttribute("courses", allCourses);
        return allCourses;
    }

    @GetMapping("/admin/course/check_repeat_course")
    @ResponseBody
    public String course_check_repeat(String name, String year) {
        Course courseByNameAndYear = courseService.findCourseByNameAndYear(name, year);
        if (courseByNameAndYear == null) {
            return "";
        }
        return "课程已经存在";
    }

    @PostMapping("/admin/course/add_course")
    public String insertCourse(String name, String year, Integer limit, HttpServletRequest request) {
        Course courseByNameAndYear = courseService.findCourseByNameAndYear(name, year);
        if (courseByNameAndYear == null) {
            courseService.insertCourse(name, year, limit);
            return "redirect:/course.html";
        } else {
            request.setAttribute("msg", "课程已经存在");
            return "course_add";
        }
    }

    @GetMapping("/admin/course/open/{c_id}")
    public String openCourse(@PathVariable("c_id") Integer c_id) {
        courseService.updateState(c_id, "开放");
        return "redirect:/course.html";
    }

    @GetMapping("/admin/course/shutdown/{c_id}")
    public String shutdownCourse(@PathVariable("c_id") Integer c_id) {
        courseService.updateState(c_id, "关闭");
        return "redirect:/course.html";
    }

    @GetMapping("/admin/course/course_password/{c_id}")
    public String modifyPasswordCourse(@PathVariable("c_id") Integer c_id, HttpServletRequest request) {
        Course courseById = courseService.findCourseById(c_id);
        request.setAttribute("c_id", courseById.getC_id());
        request.setAttribute("c_name", courseById.getName());
        request.setAttribute("c_year", courseById.getYear());
        return "course_password";
    }

    @PostMapping("/admin/course/course_password/")
    public String modifyPasswordCourse2(Integer c_id, String password) {
        courseService.updatePassword(c_id, password);
        return "redirect:/course.html";
    }
}
