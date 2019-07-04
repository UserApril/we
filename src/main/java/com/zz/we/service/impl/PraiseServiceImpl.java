package com.zz.we.service.impl;

import com.zz.we.dto.Praise;
import com.zz.we.dto.PraiseExample;
import com.zz.we.mapper.PraiseMapper;
import com.zz.we.response.Resp_common;
import com.zz.we.response.Resp_praise;
import com.zz.we.service.PraiseService;
import com.zz.we.utils.DateUtils;
import com.zz.we.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PraiseServiceImpl implements PraiseService {
    @Autowired
    public PraiseMapper praiseMapper;

    @Override
    public Object getPraiseByAppid(String appid){
        Resp_praise resp_bless =new Resp_praise();
        PraiseExample praiseExample = new PraiseExample();
        praiseExample.createCriteria().andAppidEqualTo(appid);
        List<Praise> praises = praiseMapper.selectByExample(praiseExample);
        resp_bless.setZanNum(praises.size());
        resp_bless.setZanLog(praises);
        return resp_bless;
    }

    @Override
    public Object addPraiseByMap(Map map){
        Resp_common resp_common = new Resp_common();
        String nickname=(String)map.get("nickname");
        String face=(String)map.get("face");
        if(StringUtils.isEmpty(nickname)||StringUtils.isEmpty(face)){
            resp_common.setSuccess("2");
            resp_common.setMsg("为了您更好的体验,请先同意授权");
            return resp_common;
        }
        PraiseExample praiseExample = new PraiseExample();
        praiseExample.createCriteria().andNicknameEqualTo(nickname);
        List<Praise> praises = praiseMapper.selectByExample(praiseExample);
        if (praises.size() > 0) {
            resp_common.setMsg("您的祝福新人们已经收到了哦！");
            return resp_common;
        }
        Praise praise = new Praise();
        try {
            praise.setAppid((String) map.get("appid"));
            praise.setFace(face);
            praise.setNickname(nickname);
            praise.setRequesttime(DateUtils.getDate());
            try {
                praiseMapper.insert(praise);
            } catch (Exception e) {
                System.out.println(e);
                throw new Exception("写入数据库失败");
            }
            resp_common.setSuccess("1");
            resp_common.setMsg("点赞成功");
            return resp_common;
        } catch (Exception e) {
            resp_common.setSuccess("2");
            resp_common.setMsg(e.getMessage());
            return resp_common;
        }
    }
}
