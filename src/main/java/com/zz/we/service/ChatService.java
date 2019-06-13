package com.zz.we.service;

import java.util.Map;

//好友互动留言
public interface ChatService {
    //添加留言
    public Object addChatByMap(Map map);

    //获取留言
    public Object getChatByAppid(String appid);
}
