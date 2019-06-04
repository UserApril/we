package com.zz.we.response;

import com.zz.we.dto.Praise;

import java.util.List;

public class Resp_praise {

    private int zanNum;

    private List<Praise> zanLog;

    public int getZanNum() {
        return zanNum;
    }

    public void setZanNum(int zanNum) {
        this.zanNum = zanNum;
    }

    public List<Praise> getZanLog() {
        return zanLog;
    }

    public void setZanLog(List<Praise> zanLog) {
        this.zanLog = zanLog;
    }
}
