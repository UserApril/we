package com.zz.we.response;

import com.zz.we.dto.Photos;

import java.util.List;

public class Resp_photo {

    private String title;

    private int id;

    private int start;

    private List<Photos> data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<Photos> getData() {
        return data;
    }

    public void setData(List<Photos> data) {
        this.data = data;
    }
}
