package com.nj.service;

import com.nj.model.HomeworkResponse;
import com.nj.model.mapper.HomeworkResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HomeworkResponseService {

    @Autowired
    HomeworkResponseMapper homeworkResponseMapper;

    public void insertHR(Integer u_id, Integer c_id, Integer h_id, String response) {
        LocalDate now = LocalDate.now();
        HomeworkResponse homeworkResponse = findByID(u_id, h_id);
        if (homeworkResponse == null)
            homeworkResponseMapper.insertHR(u_id, c_id, h_id, response, now.toString());
        else
            homeworkResponseMapper.updateHR(u_id, h_id, response, now.toString());
    }

    public HomeworkResponse findByID(Integer u_id, Integer h_id) {
        return homeworkResponseMapper.findByID(u_id, h_id);
    }
}
