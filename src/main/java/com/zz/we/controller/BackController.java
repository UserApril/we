package com.zz.we.controller;

import com.zz.we.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/operator")
@RestController
public class BackController {

    @Autowired
    public CommentService commentService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(@RequestParam("account") String account,@RequestParam("password") String password,@RequestParam("verifyCode") String verifyCode){

        return null;
    }

    @RequestMapping(value = "/getcomment",method = RequestMethod.POST)
    public Object getComment(@RequestParam("appid") String appid){
        return commentService.getAllCommentByAppid(appid);
    }

    @RequestMapping(value = "/delcomment",method = RequestMethod.POST)
    public Object delComment(@RequestParam("uuid") String uuid){
        return commentService.delCommentByUuid(uuid);
    }
}
