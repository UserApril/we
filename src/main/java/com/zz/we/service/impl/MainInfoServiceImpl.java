package com.zz.we.service.impl;

import com.zz.we.dto.MainInfo;
import com.zz.we.dto.MainInfoExample;
import com.zz.we.mapper.MainInfoMapper;
import com.zz.we.response.Resp_Index;
import com.zz.we.service.MainInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainInfoServiceImpl implements MainInfoService {

    @Autowired
    public MainInfoMapper mainInfoMapper;

    @Override
    public Object getMainInfoByAppid(String appid){
        Resp_Index resp_index =new Resp_Index();
        MainInfoExample mainInfoExample =new MainInfoExample();
        mainInfoExample.createCriteria().andAppidEqualTo(appid);
        List<MainInfo> mainInfos = mainInfoMapper.selectByExample(mainInfoExample);
        MainInfo mainInfo = mainInfos.get(0);
        resp_index.setMusic_url(mainInfo.getMusicUrl());
        resp_index.setMainInfo(mainInfo);
        return resp_index;
    }
}
