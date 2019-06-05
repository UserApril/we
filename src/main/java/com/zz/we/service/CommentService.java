package com.zz.we.service;

import java.util.Map;

//出席内容
public interface CommentService {

    //获取审核通过的留言互动--->chat
    public Object getCommentByAppid(String appid);

    //添加留言
    public Object addCommentByMap(Map map);

    //审核留言
    public Object updateCommentFlag(String uuid);

    //获取所有留言互动--->chat
    public Object getAllCommentByAppid(String appid);

    //删除留言互动
    public Object delCommentByUuid(String uuid);
}
