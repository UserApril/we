package com.zz.we.service;

import java.util.Map;

public interface PraiseService {

    //获取祝福信息
    public Object getPraiseByAppid(String appid);

    //添加祝福
    public Object addPraiseByMap(Map map);
}
