package com.zz.we.service.impl;

import com.zz.we.dto.MyUser;
import com.zz.we.dto.MyUserExample;
import com.zz.we.mapper.MyUserMapper;
import com.zz.we.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public MyUserMapper myUserMapper;

    @Override
    public boolean getUserByInfo(String account,String password){
        MyUserExample myUserExample =new MyUserExample();
        myUserExample.createCriteria().andAccountEqualTo(account).andPasswordEqualTo(password);
        List<MyUser> myUsers = myUserMapper.selectByExample(myUserExample);
        if(myUsers.size()>0){
            return true;
        }else{
            return false;
        }
    }
}
