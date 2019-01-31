package com.nj.model;

public class Course {
    private int c_id;
    private String name;
    private String year;
    private String select_password;
    private int limit;
    private String state;

    public Course() {
    }

    public String getSelect_password() {
        return select_password;
    }

    public void setSelect_password(String select_password) {
        this.select_password = select_password;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
