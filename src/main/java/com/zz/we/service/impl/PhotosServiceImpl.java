package com.zz.we.service.impl;

import com.zz.we.dto.Photos;
import com.zz.we.dto.PhotosExample;
import com.zz.we.mapper.PhotosMapper;
import com.zz.we.response.Resp_photo;
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
        Resp_photo resp_photo = new Resp_photo();
        resp_photo.setData(photos);
        resp_photo.setTitle("我的相册");
        resp_photo.setId(666);
        resp_photo.setStart(1);
        return resp_photo;
    }
}
