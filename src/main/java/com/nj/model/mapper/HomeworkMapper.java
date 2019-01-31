package com.nj.model.mapper;

import com.nj.model.Homework;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HomeworkMapper {

    @Insert("insert into homework(c_id,title,body,total_score,create_date,limit_date) " +
            "values (#{c_id},#{title},#{body},#{total_score},#{create_date},#{limit_date})")
    void insertHomework(Integer c_id, String title, String body, Double total_score, String create_date,  String limit_date);

    @Select("select * from homework where c_id=#{c_id}")
    List<Homework> findHwByCId(Integer c_id);

    @Delete("delete from homework where h_id=#{h_id}")
    void deleteById(Integer h_id);
}
