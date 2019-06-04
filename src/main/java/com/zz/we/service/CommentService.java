package com.zz.we.service;

import java.util.Map;

//出席内容
public interface CommentService {

    //获取留言互动--->chat
    public Object getCommentByAppid(String appid);

    //添加留言
    public Object addCommentByMap(Map map);
}
