package com.nj.model;

import org.springframework.stereotype.Repository;

@Repository
public class UserCourse {

    private int c_id;
    private int u_id;

    public UserCourse() {
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }
}
