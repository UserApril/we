package com.zz.we.controller;

import com.alibaba.fastjson.JSONObject;
import com.zz.we.dto.*;
import com.zz.we.mapper.*;
import com.zz.we.response.*;
import com.zz.we.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/wechat")
@RestController
public class mycontroller {

    @Autowired
    public MainInfoMapper mainInfoMapper;
    @Autowired
    public SlideListMapper slideListMapper;
    @Autowired
    public ChatMapper chatMapper;
    @Autowired
    public CommentMapper commentMapper;
    @Autowired
    public PraiseMapper praiseMapper;

    //酒店地址--->map
    private Object getMap(String appid){

        return null;
    }

    //相册--->photos
    private Object getPhotos(String appid){
        Resp_Photos resp_photos =new Resp_Photos();
        SlideListExample slideListExample =new SlideListExample();
        slideListExample.createCriteria().andAppidEqualTo(appid);
        List<SlideList> slideLists = slideListMapper.selectByExample(slideListExample);
        resp_photos.setSlideList(slideLists);
        return resp_photos;
    }

    //留言互动--->chat
    private Object getChat(String appid){
        Resp_chatInfo resp_chatInfo =new Resp_chatInfo();

        CommentExample commentExample =new CommentExample();
        commentExample.createCriteria().andAppidEqualTo(appid);
        List<Comment> comments = commentMapper.selectByExample(commentExample);

        resp_chatInfo.setChatNum(comments.size());
        resp_chatInfo.setChatList(comments);

        return  resp_chatInfo;
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

    //我要出席
    private Object addSign(Map map){
        Resp_common resp_chat =new Resp_common();
        try{
            Chat chat =new Chat();
            chat.setAppid((String)map.get("appid"));
            chat.setFace((String)map.get("face"));
            chat.setName((String)map.get("name"));
            chat.setNickname((String)map.get("nickname"));
            chat.setPlan((String)map.get("plan"));
            chat.setTel((String)map.get("tel"));
            chat.setExtra((String)map.get("extra"));
            try{
                chatMapper.insert(chat);
            }catch (Exception e){
                throw new Exception("插入数据库失败");
            }
            resp_chat.setSuccess("1");
            return resp_chat;
        }catch (Exception e){
            resp_chat.setSuccess("2");
            resp_chat.setMsg(e.getMessage());
            return resp_chat;
        }
    }

    //我要留言
    private Object addSend(Map map){
        Resp_common resp_common =new Resp_common();
        Comment comment =new Comment();
        try{
            comment.setAppid((String)map.get("appid"));
            comment.setFace((String)map.get("face"));
            comment.setNickname((String)map.get("nickname"));
            comment.setWords((String)map.get("words"));
            comment.setRequesttime(DateUtils.getDate());
            comment.setUpdatetime(DateUtils.getDate());
            try{
                commentMapper.insert(comment);
            }catch (Exception e){
                System.out.println(e);
                throw new Exception("插入数据库失败");
            }
            resp_common.setSuccess("1");
            return resp_common;
        }catch (Exception e){
            resp_common.setSuccess("2");
            resp_common.setMsg(e.getMessage());
            return resp_common;
        }
    }

    //好友点赞
    private Object addZan(Map map){
        Resp_common resp_common =new Resp_common();
        Praise praise =new Praise();
        try{
            praise.setAppid((String)map.get("appid"));
            praise.setFace((String)map.get("face"));
            praise.setNickname((String)map.get("nickname"));
            praise.setRequesttime(DateUtils.getDate());
            try{
                praiseMapper.insert(praise);
            }catch (Exception e){
                System.out.println(e);
                throw new Exception("插入数据库失败");
            }
            resp_common.setSuccess("1");
            return resp_common;
        }catch (Exception e){
            resp_common.setSuccess("2");
            resp_common.setMsg(e.getMessage());
            return resp_common;
        }
    }
    //好友祝福--->bless
    private Object getBless(String appid){
        Resp_bless resp_bless =new Resp_bless();
        PraiseExample praiseExample = new PraiseExample();
        praiseExample.createCriteria().andAppidEqualTo(appid);
        List<Praise> praises = praiseMapper.selectByExample(praiseExample);
        resp_bless.setZanNum(praises.size());
        resp_bless.setZanLog(praises);
        return resp_bless;
    }

    @RequestMapping(value = "/findinfo",method = RequestMethod.GET)
    public Object findInfo(@RequestParam("c") String c, @RequestParam("appid") String appid){
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

    @RequestMapping(value = "/addchat",method = RequestMethod.POST)
    public Object addChat(@RequestBody String req){
        Map map = (Map) JSONObject.parse(req);
        if("sign".equals(map.get("c"))){
            return addSign(map);
        }else if("send".equals(map.get("c"))){
            return addSend(map);
        }else if("zan".equals(map.get("c"))){
            return addSend(map);
        }else{
            return "unknow error!";
        }
    }
}
