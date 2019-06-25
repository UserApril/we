package com.zz.we.service;

import java.util.Map;

//主页信息
public interface MainInfoService {

    public Object getMainInfoByAppid(String appid);

    public Object getAllMainInfo();

    public Object updateByMap(Map map);

    public Object setMainPhoto(String appid,String src);
}
