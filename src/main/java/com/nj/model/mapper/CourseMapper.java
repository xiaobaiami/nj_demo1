package com.nj.model.mapper;

import com.nj.model.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CourseMapper {

    @Insert("insert into course(name,year,`limit`, state) values (#{name},#{year},#{limit}, #{state})")
    void insertCourse(String name, String year, int limit, String state);

    @Select("select * from course where name=#{name} and year=#{year}")
    Course findCourseByNameAndYear(String name, String year);

    @Select("select * from course where c_id=#{c_id}")
    Course findCourseById(Integer c_id);

    @Select("select * from course where 1=1")
    List<Course> findAllCourse();

    @Select("select * from course where year=#{year}")
    List<Course> findCourseByYear(String year);

    @Update("update course set name=#{name},`select_password`=#{select_password},year=#{year},state=#{state} where c_id=#{c_id}")
    void update(Course course);
}
