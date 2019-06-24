package com.zz.we.controller;

import com.alibaba.fastjson.JSONObject;
import com.zz.we.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/operator")
@RestController
public class BackController {

    @Autowired
    public CommentService commentService;
    @Autowired
    public MainInfoService mainInfoService;
    @Autowired
    public ChatService chatService;
    @Autowired
    public PhotosService photosService;

    //获取所有留言
    @RequestMapping(value = "/getcomment",method = RequestMethod.POST)
    public Object getComment(@RequestParam("appid") String appid){
        return commentService.getAllCommentByAppid(appid);
    }

    //删除指定留言
    @RequestMapping(value = "/delcomment",method = RequestMethod.POST)
    public Object delComment(@RequestParam("uuid") String uuid){
        return commentService.delCommentByUuid(uuid);
    }

    //修改留言状态
    @RequestMapping(value = "/updatecomment",method = RequestMethod.POST)
    public Object updateComment(@RequestParam("uuid") String uuid){
        return commentService.updateCommentFlag(uuid);
    }

    //获取结婚信息
    @RequestMapping(value = "/getmaininfo",method = RequestMethod.POST)
    public Object getMainInfo(){
        return mainInfoService.getAllMainInfo();
    }

    //修改请柬基础信息
    @RequestMapping(value = "/updatemaininfo",method = RequestMethod.POST)
    public Object updateMainInfo(@RequestBody String req){
        Map map = (Map) JSONObject.parse(req);
        return mainInfoService.updateByMap(map);
    }

    //查询出席信息
    @RequestMapping(value = "/getchat",method = RequestMethod.POST)
    public Object getChat(@RequestParam("appid") String appid){
        return chatService.getChatByAppid(appid);
    }

    //查询所有相册
    @RequestMapping(value = "/getphotos",method = RequestMethod.POST)
    public Object getPhotos(@RequestParam("appid")String appid){
        return photosService.getPhotosByAppid(appid);
    }

    //删除指定照片
    @RequestMapping(value = "/delphotos",method = RequestMethod.POST)
    public Object delPhotoByAppid(@RequestParam("appid")String appid,@RequestParam("pid")String pid){
        return photosService.delPhotoByid(appid,pid);
    }
}
