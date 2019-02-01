package com.nj.model.mapper;

import com.nj.model.HomeworkResponse;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface HomeworkResponseMapper {

    @Insert("insert into homework_response(u_id,c_id,h_id,response,create_date) values " +
            "(#{u_id},#{c_id},#{h_id},#{response},#{create_date})")
    void insertHR(Integer u_id, Integer c_id, Integer h_id, String response, String create_date);


    @Select("select * from homework_response where u_id=#{u_id} and h_id=#{h_id}")
    HomeworkResponse findByID(Integer u_id, Integer h_id);

    @Update("update homework_response set response=#{response},create_date=#{create_date} " +
            "where u_id=#{u_id} and h_id=#{h_id}")
    void updateHR(Integer u_id, Integer h_id, String response, String create_date);
}
