package com.nj.service;

import com.nj.model.Homework;
import com.nj.model.mapper.HomeworkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class HomeworkService {

    @Autowired
    HomeworkMapper homeworkMapper;

    public List<Homework> findHwByCId(Integer c_id) {
        List<Homework> hwByCId = homeworkMapper.findHwByCId(c_id);
        return hwByCId;
    }


    public void insertHw(Integer c_id, String title, Double total_score, Integer days, String body) {
        LocalDate now = LocalDate.now();
        LocalDate limit = now.plusDays(days + 1);
        homeworkMapper.insertHomework(c_id, title, body, total_score, now.toString(), limit.toString());
    }


    public void deleteHw(Integer h_id) {
        homeworkMapper.deleteById(h_id);
    }

    public List<Homework> findOnesHw(Integer u_id, Integer c_id) {
        if (c_id != -1)
            return homeworkMapper.findHwByCId(c_id);
        return null;
    }
}
