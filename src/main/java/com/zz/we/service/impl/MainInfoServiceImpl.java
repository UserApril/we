package com.zz.we.service.impl;

import com.zz.we.dto.MainInfo;
import com.zz.we.dto.MainInfoExample;
import com.zz.we.mapper.MainInfoMapper;
import com.zz.we.response.Resp_Index;
import com.zz.we.response.Resp_com_back;
import com.zz.we.response.Resp_common;
import com.zz.we.service.MainInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public Object getAllMainInfo() {
        MainInfoExample mainInfoExample =new MainInfoExample();
        List<MainInfo> mainInfos = mainInfoMapper.selectByExample(mainInfoExample);
        Resp_com_back resp_com_back =new Resp_com_back();
        resp_com_back.setData(mainInfos);
        resp_com_back.setCode(0);
        resp_com_back.setCount(mainInfos.size());
        return resp_com_back;
    }

    @Override
    public Object updateByMap(Map map) {
        Resp_common resp_common =new Resp_common();
        MainInfoExample mainInfoExample =new MainInfoExample();
        mainInfoExample.createCriteria().andAppidEqualTo((String)map.get("appid"));
        MainInfo mainInfo =new MainInfo();
        mainInfo.setHe((String)map.get("he"));
        mainInfo.setShe((String)map.get("she"));
        mainInfo.setAddress((String)map.get("address"));
        try{
            mainInfo.setDate((String)map.get("date"));
        }catch (Exception e){
            resp_common.setSuccess("2");
            resp_common.setMsg("修改失败，日期格式输入错误。");
            return resp_common;
        }
        mainInfo.setHotel((String)map.get("hotel"));
        mainInfo.setLunar((String)map.get("lunar"));
        mainInfoMapper.updateByExampleSelective(mainInfo,mainInfoExample);
        resp_common.setSuccess("1");
        resp_common.setMsg("修改成功");
        return resp_common;
    }

    @Override
    public Object setMainPhoto(String appid,String src) {
        MainInfo mainInfo = new MainInfo();
        mainInfo.setCover(src);
        MainInfoExample mainInfoExample =new MainInfoExample();
        mainInfoExample.createCriteria().andAppidEqualTo(appid);
        mainInfoMapper.updateByExampleSelective(mainInfo,mainInfoExample);
        Resp_common resp_common =new Resp_common();
        resp_common.setSuccess("1");
        resp_common.setMsg("设置成功");
        return resp_common;
    }
}
