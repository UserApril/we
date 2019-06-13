package com.zz.we.controller;

import com.alibaba.fastjson.JSONObject;
import com.zz.we.service.ChatService;
import com.zz.we.service.CommentService;
import com.zz.we.service.MainInfoService;
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
}