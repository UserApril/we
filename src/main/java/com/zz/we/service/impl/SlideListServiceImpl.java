package com.zz.we.service.impl;

import com.zz.we.dto.SlideList;
import com.zz.we.dto.SlideListExample;
import com.zz.we.mapper.SlideListMapper;
import com.zz.we.response.Resp_Photos;
import com.zz.we.response.Resp_common;
import com.zz.we.service.SlideListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SlideListServiceImpl implements SlideListService {
    @Autowired
    public SlideListMapper slideListMapper;

    @Override
    public Object getPhotosByAppid(String appid){
        Resp_Photos resp_photos =new Resp_Photos();
        SlideListExample slideListExample =new SlideListExample();
        slideListExample.createCriteria().andAppidEqualTo(appid);
        List<SlideList> slideLists = slideListMapper.selectByExample(slideListExample);
        resp_photos.setSlideList(slideLists);
        return resp_photos;
    }

    @Override
    public Object addPhotosByMap(Map map) {
        Resp_common resp_common =new Resp_common();
        SlideList slideList =new SlideList();
        slideList.setImage((String)map.get("image"));
        slideList.setAppid((String)map.get("appid"));
        slideListMapper.insert(slideList);
        resp_common.setMsg("添加成功");
        resp_common.setSuccess("1");
        return resp_common;
    }
}
