package com.zz.we.service.impl;

import com.zz.we.dto.Chat;
import com.zz.we.mapper.ChatMapper;
import com.zz.we.response.Resp_common;
import com.zz.we.service.ChatService;
import com.zz.we.utils.DateUtils;
import com.zz.we.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    public ChatMapper chatMapper;

    @Override
    public Object addChatByMap(Map map){
        Resp_common resp_common =new Resp_common();
        String nickname=(String)map.get("nickname");
        String face=(String)map.get("face");
        if(StringUtils.isEmpty(nickname)||StringUtils.isEmpty(face)){
            resp_common.setSuccess("2");
            resp_common.setMsg("为了您更好的体验,请先同意授权");
            return resp_common;
        }
        try{
            Chat chat =new Chat();
            chat.setAppid((String)map.get("appid"));
            chat.setFace(face);
            chat.setName((String)map.get("name"));
            chat.setNickname(nickname);
            chat.setPlan((String)map.get("plan"));
            chat.setTel((String)map.get("tel"));
            chat.setExtra((String)map.get("extra"));
            chat.setRequesttime(DateUtils.getDate());
            chat.setUpdatetime(DateUtils.getDate());
            try{
                chatMapper.insert(chat);
            }catch (Exception e){
                throw new Exception("写入数据库失败");
            }
            resp_common.setSuccess("1");
            resp_common.setMsg("留言成功");
            return resp_common;
        }catch (Exception e){
            resp_common.setSuccess("2");
            resp_common.setMsg(e.getMessage());
            return resp_common;
        }
    }
}
