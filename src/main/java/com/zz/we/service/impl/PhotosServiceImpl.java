package com.zz.we.service.impl;

import com.zz.we.dto.Photos;
import com.zz.we.dto.PhotosExample;
import com.zz.we.mapper.PhotosMapper;
import com.zz.we.response.Resp_com_back;
import com.zz.we.response.Resp_common;
import com.zz.we.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotosServiceImpl implements PhotosService {
    @Autowired
    public PhotosMapper photosMapper;

    @Override
    public Object getPhotosByAppid(String appid) {
        PhotosExample photosExample =new PhotosExample();
        photosExample.createCriteria().andAppidEqualTo(appid);
        List<Photos> photos = photosMapper.selectByExample(photosExample);
        Resp_com_back resp_com_back =new Resp_com_back();
        resp_com_back.setData(photos);
        resp_com_back.setCode(0);
        resp_com_back.setCount(photos.size());
        return resp_com_back;
    }

    @Override
    public Object delPhotoByid(String appid, String pid) {
        PhotosExample photosExample =new PhotosExample();
        photosExample.createCriteria().andAppidEqualTo(appid).andPidEqualTo(Integer.parseInt(pid));
        int i = photosMapper.deleteByExample(photosExample);
        Resp_common resp_common =new Resp_common();
        resp_common.setSuccess("1");
        resp_common.setMsg("删除成功");
        return resp_common;
    }
}
