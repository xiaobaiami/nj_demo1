package com.nj.controller;

import com.nj.model.HomeworkResponse;
import com.nj.service.HomeworkResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeworkResponseController {

    @Autowired
    HomeworkResponseService homeworkResponseService;

    @GetMapping("/homework_response")
    @ResponseBody
    public String homework_response(Integer h_id, HttpServletRequest request) {
        Integer u_id = (Integer) request.getSession().getAttribute("u_id");
        HomeworkResponse byID = homeworkResponseService.findByID(u_id, h_id);
        return byID == null ? "" : byID.getResponse();
    }
}
