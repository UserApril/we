package com.zz.we.service.impl;

import com.zz.we.dto.Photos;
import com.zz.we.dto.PhotosExample;
import com.zz.we.mapper.PhotosMapper;
import com.zz.we.response.Resp_com_back;
import com.zz.we.response.Resp_common;
import com.zz.we.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
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
        List<Photos> photos = photosMapper.selectByExample(photosExample);
        String src = photos.get(0).getSrc();
        int i = photosMapper.deleteByExample(photosExample);
        String path = src.substring(src.lastIndexOf("/") + 1);
        System.err.println("path:"+path);
        try{
            File file =new File("webapp/imgs/"+path);
            file.deleteOnExit();
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        Resp_common resp_common =new Resp_common();
        resp_common.setSuccess("1");
        resp_common.setMsg("删除成功");
        return resp_common;
    }

    @Override
    public void addPhotos(String desFilePath,String alt,String appid) {
        PhotosExample photosExample =new PhotosExample();
        photosExample.createCriteria().andAppidEqualTo(appid);
        long count = photosMapper.countByExample(photosExample);
        Photos photos =new Photos();
        String path="https://cdwork.xyz/imgs/"+desFilePath;
        photos.setAlt(alt);
        photos.setPid((int) ++count);
        photos.setSrc(path);
        photos.setAppid(appid);
        photosMapper.insert(photos);
    }
}
