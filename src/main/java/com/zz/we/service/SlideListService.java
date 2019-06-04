package com.zz.we.service;

import java.util.Map;

//我的相册
public interface SlideListService {

    //读取相册--->photos
    public Object getPhotosByAppid(String appid);

    public Object addPhotosByMap(Map map);
}
