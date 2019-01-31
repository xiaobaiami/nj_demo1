package com.nj.controller;

import com.nj.model.Course;
import com.nj.model.Homework;
import com.nj.service.CourseService;
import com.nj.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeworkController {

    @Autowired
    CourseService courseService;
    @Autowired
    HomeworkService homeworkService;

    @GetMapping("/admin/course/homework/{c_id}")
    public String homework_main(@PathVariable("c_id") Integer c_id, HttpServletRequest request) {
        Course courseById = courseService.findCourseById(c_id);
        List<Homework> hwByCId = homeworkService.findHwByCId(c_id);
        request.setAttribute("c_id", courseById.getC_id());
        request.setAttribute("hws", hwByCId);
        return "homework";
    }

    @PostMapping("/admin/course/homework_add")
    public String homework_add(Integer c_id, String title, Double total_score, Integer days, String body) {
        homeworkService.insertHw(c_id, title, total_score, days, body);
        return "redirect:/admin/course/homework/" + c_id;
    }

    @GetMapping("/admin/course/homework_delete")
    public String homework_delete(Integer h_id, Integer c_id) {
        homeworkService.deleteHw(h_id);
        return "redirect:/admin/course/homework/" + c_id;
    }

    @GetMapping("/homework/main")
    public String homework_main2(Integer c_id, HttpServletRequest request) {
        Integer u_id = (Integer)request.getSession().getAttribute("u_id");
        List<Homework> hwByCId = homeworkService.findOnesHw(u_id, c_id);
        request.setAttribute("my_hw", hwByCId);
        return "my_hw";
    }
}
