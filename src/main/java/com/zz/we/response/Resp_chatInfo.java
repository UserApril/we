package com.zz.we.response;

import com.zz.we.dto.Comment;

import java.util.List;

public class Resp_chatInfo {

    private int chatNum;

    private List<Comment> chatList;

    public int getChatNum() {
        return chatNum;
    }

    public void setChatNum(int chatNum) {
        this.chatNum = chatNum;
    }

    public List<Comment> getChatList() {
        return chatList;
    }

    public void setChatList(List<Comment> chatList) {
        this.chatList = chatList;
    }
}
