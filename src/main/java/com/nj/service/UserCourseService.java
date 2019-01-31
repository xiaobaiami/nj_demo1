package com.nj.service;

import com.nj.model.Course;
import com.nj.model.UserCourse;
import com.nj.model.mapper.CourseMapper;
import com.nj.model.mapper.UserCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCourseService {

    @Autowired
    UserCourseMapper userCourseMapper;
    @Autowired
    CourseMapper courseMapper;

    public List<UserCourse> findByIds(Integer c_id, Integer u_id) {
        return userCourseMapper.findByIds(c_id, u_id);
    }

    public String checkOutCourseAvailbale(Integer c_id, Integer u_id) {
        Course courseById = courseMapper.findCourseById(c_id);
        if (courseById == null)
            return "没有这门课";
        if ("关闭".equalsIgnoreCase(courseById.getState()))
            return "课程关闭，不能选课";
        List<UserCourse> byIds = findByIds(c_id, u_id);
        if (byIds.size()!=0)
            return "已选";
        return "";
    }

    public void insertUserCourse(Integer c_id, Integer u_id) {
        userCourseMapper.insertUserCourse(c_id, u_id);
    }

    public List<Course> findCourseByUid(Integer u_id, String year) {
        if ("all".equalsIgnoreCase(year))
            return userCourseMapper.findCourseByUid(u_id);
        return userCourseMapper.findCourseByUidAndYear(u_id, year);
    }

    public boolean delete(Integer c_id, Integer u_id) {
        List<UserCourse> byIds = findByIds(c_id, u_id);
        if (byIds.size() == 0)
            return false;
        userCourseMapper.delete(c_id, u_id);
        return true;
    }
}
