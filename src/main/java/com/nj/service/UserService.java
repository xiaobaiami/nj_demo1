package com.nj.service;

import com.nj.model.User;
import com.nj.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public boolean register(String email, String password, int type){
        User userByEmail = userMapper.findUserByEmail(email);
        if (userByEmail == null) {
            userMapper.insertUser(email,password,type);
            return true;
        }
        return false;
    }

    public User login(String email, String password){
        User userByEmailAndPassword = userMapper.findUserByEmailAndPassword(email, password);
        return userByEmailAndPassword;
    }
}
