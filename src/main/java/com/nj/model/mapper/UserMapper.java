package com.nj.model.mapper;

import com.nj.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user(email,password,type) values (#{email},#{password},#{type})")
    void insertUser(String email, String password, int type);

    @Select("select * from user where email=#{email}")
    User findUserByEmail(String email);

    @Select("select * from user where email=#{email} and password=#{password}")
    User findUserByEmailAndPassword(String email, String password);
}
