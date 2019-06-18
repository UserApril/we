package com.zz.we.controller;

import com.alibaba.fastjson.JSONObject;
import com.zz.we.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/wechat")
@RestController
public class ForeController {

    @Autowired
    public MainInfoService mainInfoService;
    @Autowired
    public PhotosService photosService;
    @Autowired
    public ChatService chatService;
    @Autowired
    public CommentService commentService;
    @Autowired
    public PraiseService praiseService;
    @Autowired
    public MmapService mmapService;

    @RequestMapping(value = "/findinfo",method = RequestMethod.GET)
    public Object findInfo(@RequestParam("c") String c, @RequestParam("appid") String appid){
        if("map".equals(c)){
            return mmapService.getMapByAppid(appid);
        }else if("photos".equals(c)){
            return photosService.getPhotosByAppid(appid);
        }else if("index".equals(c)){
            return mainInfoService.getMainInfoByAppid(appid);
        }else if("chat".equals(c)){
            return commentService.getCommentByAppid(appid);
        }else if("bless".equals(c)){
            return praiseService.getPraiseByAppid(appid);
        }else{
            return "404 Not Found!";
        }
    }

    @RequestMapping(value = "/addchat",method = RequestMethod.POST)
    public Object addChat(@RequestBody String req){
        Map map = (Map) JSONObject.parse(req);
        if("sign".equals(map.get("c"))){
            return chatService.addChatByMap(map);
        }else if("send".equals(map.get("c"))){
            return commentService.addCommentByMap(map);
        }else if("zan".equals(map.get("c"))){
            return praiseService.addPraiseByMap(map);
        }else{
            return "404 Not Found!";
        }
    }
}
