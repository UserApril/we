package com.zz.we.service;

public interface PhotosService {

    public Object getPhotosByAppid(String appid);

    public Object getPhotosByAppid(String appid,String pid);

    public Object delPhotoByid(String appid,String pid);

    void addPhotos(String desFilePath,String alt,String appid);
}
