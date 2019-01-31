package com.nj.service;

import com.nj.model.Course;
import com.nj.model.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseMapper courseMapper;


    public List<Course> findAllCourses(String year) {
        if ("all".equalsIgnoreCase(year)) {
            List<Course> allCourse = courseMapper.findAllCourse();
            return allCourse;
        } else
            return courseMapper.findCourseByYear(year);
    }

    public Course findCourseByNameAndYear(String name, String year) {
        Course courseByNameAndYear = courseMapper.findCourseByNameAndYear(name, year);
        return courseByNameAndYear;
    }

    public Course findCourseById(Integer c_id) {
        Course courseByNameAndYear = courseMapper.findCourseById(c_id);
        return courseByNameAndYear;
    }

    public void insertCourse(String name, String year, Integer limit) {
        courseMapper.insertCourse(name, year, limit, "关闭");
    }

    public void updateState(Integer c_id, String state) {
        Course courseById = courseMapper.findCourseById(c_id);
        courseById.setState(state);
        courseMapper.update(courseById);
    }

    public void updatePassword(Integer c_id, String password) {
        Course courseById = courseMapper.findCourseById(c_id);
        courseById.setSelect_password(password);
        courseMapper.update(courseById);
    }

}
