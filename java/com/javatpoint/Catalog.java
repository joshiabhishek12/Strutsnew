package com.javatpoint;

public class Catalog {
    private String catlog_id;
    private String catlog_name;
    private String catlog_dis;

    public Catalog(String catlog_id, String catlog_name, String catlog_dis) {
        this.catlog_id = catlog_id;
        this.catlog_name = catlog_name;
        this.catlog_dis = catlog_dis;
    }

    public String getCatlog_id() {
        return catlog_id;
    }

    public void setCatlog_id(String catlog_id) {
        this.catlog_id = catlog_id;
    }

    public String getCatlog_name() {
        return catlog_name;
    }

    public void setCatlog_name(String catlog_name) {
        this.catlog_name = catlog_name;
    }

    public String getCatlog_dis() {
        return catlog_dis;
    }

    public void setCatlog_dis(String catlog_dis) {
        this.catlog_dis = catlog_dis;
    }
}
