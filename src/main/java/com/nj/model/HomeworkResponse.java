package com.nj.model;

import org.springframework.stereotype.Repository;

@Repository
public class HomeworkResponse {
    private Integer hr_id;
    private Integer u_id;
    private Integer c_id;
    private Integer h_id;
    private String response;
    private String create_date;

    public HomeworkResponse() {
    }

    public Integer getHr_id() {
        return hr_id;
    }

    public void setHr_id(Integer hr_id) {
        this.hr_id = hr_id;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public Integer getH_id() {
        return h_id;
    }

    public void setH_id(Integer h_id) {
        this.h_id = h_id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
}
