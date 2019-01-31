package com.nj.controller;

import com.nj.model.Course;
import com.nj.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserCourseController {

    @Autowired
    UserCourseService userCourseService;

    @GetMapping("/course/choose/{c_id}")
    public String courseChoose(@PathVariable("c_id") Integer c_id, HttpServletRequest request) {
        Integer u_id = (Integer) request.getSession().getAttribute("u_id");
        String msg = userCourseService.checkOutCourseAvailbale(c_id, u_id);
        if (!msg.isEmpty()) {
            request.setAttribute("msg", msg);
            return "course";
        } else {
            userCourseService.insertUserCourse(c_id, u_id);
            request.setAttribute("msg", "选课成功");
            return "course";
        }
    }


    @GetMapping("/user/course/list")
    @ResponseBody
    public List<Course> findMyAllCourses(String year, HttpServletRequest request) {
        Integer u_id = (Integer) request.getSession().getAttribute("u_id");
        List<Course> courseByUid = userCourseService.findCourseByUid(u_id, year);
        return courseByUid;
    }

    @GetMapping("/user/course/reback/{c_id}")
    public String deleteCourse(@PathVariable("c_id") Integer c_id, HttpServletRequest request) {
        Integer u_id = (Integer) request.getSession().getAttribute("u_id");
        boolean delete = userCourseService.delete(c_id, u_id);
        if (delete)
            return "redirect:/dashboard.html";
        else {
            request.setAttribute("msg","删除失败");
            return "dashboard.html";
        }

    }
}
