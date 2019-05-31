package com.zz.we.controller;

import com.zz.we.dto.*;
import com.zz.we.mapper.ItemMapper;
import com.zz.we.mapper.MainInfoMapper;
import com.zz.we.mapper.SlideListMapper;
import com.zz.we.response.Resp_Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/wechat")
@RestController
public class mycontroller {

    @Autowired
    public ItemMapper itemMapper;

    @Autowired
    public MainInfoMapper mainInfoMapper;

    @Autowired
    public SlideListMapper slideListMapper;

    //酒店地址--->map
    private Object getMap(String appid){
        ItemExample itemExample =new ItemExample();
        List<Item> items = itemMapper.selectByExample(itemExample);
        return items;
    }

    //相册--->photos
    private Object getPhotos(String appid){
        MainInfoExample mainInfoExample =new MainInfoExample();
        List<MainInfo> mainInfos = mainInfoMapper.selectByExample(mainInfoExample);
        return mainInfos;
    }

    //留言互动--->chat
    private Object getChat(String appid){
        SlideListExample slideListExample =new SlideListExample();
        List<SlideList> slideLists = slideListMapper.selectByExample(slideListExample);
        return  slideLists;
    }

    //邀请函---->index
    private Object getIndex(String appid){
        Resp_Index resp_index =new Resp_Index();
        MainInfoExample mainInfoExample =new MainInfoExample();
        mainInfoExample.createCriteria().andAppidEqualTo(appid);
        List<MainInfo> mainInfos = mainInfoMapper.selectByExample(mainInfoExample);
        MainInfo mainInfo = mainInfos.get(0);
        resp_index.setMusic_url(mainInfo.getMusicUrl());
        resp_index.setMainInfo(mainInfo);
        return resp_index;
    }

    //好友祝福--->bless
    private Object getBless(String appid){
        return null;
    }

    @RequestMapping(value = "/input",method = RequestMethod.GET)
    public Object input(@RequestParam("c") String c, @RequestParam("appid") String appid){
        if("map".equals(c)){
            return getMap(appid);
        }else if("photos".equals(c)){
            return getPhotos(appid);
        }else if("index".equals(c)){
            return getIndex(appid);
        }else if("chat".equals(c)){
            return getChat(appid);
        }else if("bless".equals(c)){
            return getBless(appid);
        }else{
            return "unknow error!";
        }
    }
}
