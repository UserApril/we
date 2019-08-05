package com.zz.we.controller;

import com.alibaba.fastjson.JSONObject;
import com.zz.we.dto.ImgResult;
import com.zz.we.service.ChatService;
import com.zz.we.service.CommentService;
import com.zz.we.service.MainInfoService;
import com.zz.we.service.PhotosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/operator")
@RestController
public class BackController {
    private static final Logger log = LoggerFactory.getLogger(BackController.class);

    @Autowired
    public CommentService commentService;
    @Autowired
    public MainInfoService mainInfoService;
    @Autowired
    public ChatService chatService;
    @Autowired
    public PhotosService photosService;

    //获取所有留言
    @RequestMapping(value = "/getcomment",method = RequestMethod.POST)
    public Object getComment(@RequestParam("appid") String appid){
        log.info("[获取所有留言]---->>>>>star<<<<<----");
        return commentService.getAllCommentByAppid(appid);
    }

    //删除指定留言
    @RequestMapping(value = "/delcomment",method = RequestMethod.POST)
    public Object delComment(@RequestParam("uuid") String uuid){
        log.info("[删除指定留言]---->>>>>star<<<<<----");
        return commentService.delCommentByUuid(uuid);
    }

    //修改留言状态
    @RequestMapping(value = "/updatecomment",method = RequestMethod.POST)
    public Object updateComment(@RequestParam("uuid") String uuid){
        log.info("[修改留言状态]---->>>>>star<<<<<----");
        return commentService.updateCommentFlag(uuid);
    }

    //获取结婚信息
    @RequestMapping(value = "/getmaininfo",method = RequestMethod.POST)
    public Object getMainInfo(){
        log.info("[获取结婚信息]---->>>>>star<<<<<----");
        return mainInfoService.getAllMainInfo();
    }

    //修改请柬基础信息
    @RequestMapping(value = "/updatemaininfo",method = RequestMethod.POST)
    public Object updateMainInfo(@RequestBody String req){
        log.info("[修改请柬基础信息]---->>>>>star<<<<<----");
        Map map = (Map) JSONObject.parse(req);
        return mainInfoService.updateByMap(map);
    }

    //查询出席信息
    @RequestMapping(value = "/getchat",method = RequestMethod.POST)
    public Object getChat(@RequestParam("appid") String appid){
        log.info("[查询出席信息]---->>>>>star<<<<<----");
        return chatService.getChatByAppid(appid);
    }

    //查询所有相册
    @RequestMapping(value = "/getphotos",method = RequestMethod.POST)
    public Object getPhotos(@RequestParam("appid")String appid){
        log.info("[查询所有相册]---->>>>>star<<<<<----");
        return photosService.getPhotosByAppid(appid);
    }

    //删除指定照片
    @RequestMapping(value = "/delphotos",method = RequestMethod.POST)
    public Object delPhotoByAppid(@RequestParam("appid")String appid,@RequestParam("pid")String pid){
        log.info("[删除指定照片]---->>>>>star<<<<<----");
        return photosService.delPhotoByid(appid,pid);
    }

    //上传文件
    @RequestMapping("/upload")
    public ImgResult uplpad(MultipartFile file, HttpServletRequest request) {
        log.info("[上传文件]---->>>>>star<<<<<----");
        String desFilePath = "";
        String oriName = "";
        ImgResult result = new ImgResult();
        Map<String, String> dataMap = new HashMap<>();
        ImgResult imgResult = new ImgResult();
        try {
            // 1.获取原文件名
            oriName = file.getOriginalFilename();
            String fileName =oriName.substring(oriName.lastIndexOf("\\")+1,oriName.lastIndexOf("."));
            // 2.获取原文件图片后缀，以最后的.作为截取(.jpg)
            String extName = oriName.substring(oriName.lastIndexOf("."));
            // 3.生成自定义的新文件名，这里以UUID.jpg|png|xxx作为格式（可选操作，也可以不自定义新文件名）
            String uuid = UUID.randomUUID().toString();
            String newName = uuid + extName;
            // 4.获取要保存的路径文件夹
            String realPath = request.getRealPath("imgs");
            // 5.保存
            desFilePath = realPath + "//" + newName;
            File desFile = new File(desFilePath);
            file.transferTo(desFile);
            // 6.返回保存结果信息
            result.setCode(0);
            dataMap = new HashMap<>();
            dataMap.put("src", "webapp/imgs/" + newName);
            result.setData(dataMap);
            result.setMsg(oriName + "上传成功！");
            photosService.addPhotos(newName,fileName,"wxbeebcb78fb226416");
            return result;
        } catch (IllegalStateException e) {
            imgResult.setCode(1);
            return imgResult;
        } catch (IOException e) {
            imgResult.setCode(1);
            return imgResult;
        }
    }

    //设置主页
    @RequestMapping("/setmain")
    public Object setMain(@RequestParam("appid")String appid,@RequestParam("pid")String pid){
        log.info("[设置主页照片]---->>>>>star<<<<<----");
        Object value = photosService.getPhotosByAppid(appid, pid);
        return mainInfoService.setMainPhoto(appid,(String)value);
    }
}
