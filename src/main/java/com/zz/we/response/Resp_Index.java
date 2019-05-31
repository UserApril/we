package com.zz.we.response;

import com.zz.we.dto.MainInfo;

public class Resp_Index {

    private String music_url;

    private MainInfo mainInfo;

    public String getMusic_url() {
        return music_url;
    }

    public void setMusic_url(String music_url) {
        this.music_url = music_url;
    }

    public MainInfo getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(MainInfo mainInfo) {
        this.mainInfo = mainInfo;
    }
}
