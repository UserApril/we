package com.zz.we.service.impl;

import com.zz.we.dto.Comment;
import com.zz.we.dto.CommentExample;
import com.zz.we.enums.Comment_enum;
import com.zz.we.mapper.CommentMapper;
import com.zz.we.mapper.ICommentMapper;
import com.zz.we.response.Resp_chatInfo;
import com.zz.we.response.Resp_com_back;
import com.zz.we.response.Resp_common;
import com.zz.we.service.CommentService;
import com.zz.we.utils.DateUtils;
import com.zz.we.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    public CommentMapper commentMapper;
    @Autowired
    public ICommentMapper iCommentMapper;

    @Override
    public Object getCommentByAppid(String appid){
        Resp_chatInfo resp_chatInfo =new Resp_chatInfo();

        CommentExample commentExample =new CommentExample();
        commentExample.createCriteria().andAppidEqualTo(appid).andFlagEqualTo(Comment_enum.PASS.Code());
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
            comment.setUuid(UUID.randomUUID().toString());
            comment.setAppid((String)map.get("appid"));
            comment.setFace(face);
            comment.setNickname(nickname);
            comment.setWords((String)map.get("words"));
            comment.setRequesttime(DateUtils.getDate());
            comment.setUpdatetime(DateUtils.getDate());
            comment.setFlag(Comment_enum.PASS.Code());
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

    @Override
    public Object updateCommentFlag(String uuid) {
        CommentExample commentExample =new CommentExample();
        commentExample.createCriteria().andUuidEqualTo(uuid);
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        Comment comment = comments.get(0);
        Resp_common resp_common=new Resp_common();
        try{
            if(comment.getFlag().equals("2")){
                iCommentMapper.updateComment(uuid,Comment_enum.UNPASS.Code());
            }else{
                iCommentMapper.updateComment(uuid,Comment_enum.PASS.Code());
            }
            resp_common.setSuccess("1");
            resp_common.setMsg("操作成功");
        }catch (Exception e){
            resp_common.setSuccess("2");
            resp_common.setMsg("操作失败，"+e.getStackTrace());
        }
        return resp_common;
    }

    @Override
    public Object getAllCommentByAppid(String appid) {
        CommentExample commentExample =new CommentExample();
        commentExample.createCriteria().andAppidEqualTo(appid);
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        Resp_com_back resp_com_back =new Resp_com_back();
        resp_com_back.setData(comments);
        resp_com_back.setCode(0);
        resp_com_back.setCount(comments.size());
        return resp_com_back;
    }

    @Override
    public Object delCommentByUuid(String uuid) {
        CommentExample commentExample =new CommentExample();
        commentExample.createCriteria().andUuidEqualTo(uuid);
        int i = commentMapper.deleteByExample(commentExample);
        Resp_common resp_common =new Resp_common();
        if(i>0){
            resp_common.setSuccess("1");
            resp_common.setMsg("删除成功");
        }else{
            resp_common.setSuccess("2");
            resp_common.setMsg("删除失败，该数据不存在。");
        }
        return resp_common;
    }

}
