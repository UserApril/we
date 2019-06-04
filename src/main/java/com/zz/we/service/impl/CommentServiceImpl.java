package com.zz.we.service.impl;

import com.zz.we.dto.Comment;
import com.zz.we.dto.CommentExample;
import com.zz.we.mapper.CommentMapper;
import com.zz.we.response.Resp_chatInfo;
import com.zz.we.response.Resp_common;
import com.zz.we.service.CommentService;
import com.zz.we.utils.DateUtils;
import com.zz.we.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    public CommentMapper commentMapper;

    @Override
    public Object getCommentByAppid(String appid){
        Resp_chatInfo resp_chatInfo =new Resp_chatInfo();

        CommentExample commentExample =new CommentExample();
        commentExample.createCriteria().andAppidEqualTo(appid);
        List<Comment> comments = commentMapper.selectByExample(commentExample);

        resp_chatInfo.setChatNum(comments.size());
        resp_chatInfo.setChatList(comments);

        return  resp_chatInfo;
    }

    @Override
    public Object addCommentByMap(Map map){
        Resp_common resp_common =new Resp_common();
        Comment comment =new Comment();
        String nickname=(String)map.get("nickname");
        String face=(String)map.get("face");
        if(StringUtils.isEmpty(nickname)||StringUtils.isEmpty(face)){
            resp_common.setSuccess("2");
            resp_common.setMsg("为了您更好的体验,请先同意授权");
            return resp_common;
        }
        try{
            comment.setAppid((String)map.get("appid"));
            comment.setFace(face);
            comment.setNickname(nickname);
            comment.setWords((String)map.get("words"));
            comment.setRequesttime(DateUtils.getDate());
            comment.setUpdatetime(DateUtils.getDate());
            try{
                commentMapper.insert(comment);
            }catch (Exception e){
                System.out.println(e);
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
