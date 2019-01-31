package com.nj.model.mapper;

import com.nj.model.Course;
import com.nj.model.UserCourse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserCourseMapper {

    @Insert("insert into user_course values (#{c_id}, #{u_id})")
    void insertUserCourse(Integer c_id, Integer u_id);

    @Select("select * from user_course where c_id=#{c_id} and u_id=#{u_id}")
    List<UserCourse> findByIds(Integer c_id, Integer u_id);

    @Select("select c.* from course c where c_id in (select c_id from user_course where u_id=#{u_id})")
    List<Course> findCourseByUid(Integer u_id);

    @Select("select c.* from course c where c_id in (select c_id from user_course where u_id=#{u_id}) and year=#{year}")
    List<Course> findCourseByUidAndYear(Integer u_id, String year);

    @Delete("delete from user_course where c_id=#{c_id} and u_id=#{u_id}")
    void delete(Integer c_id, Integer u_id);
}
