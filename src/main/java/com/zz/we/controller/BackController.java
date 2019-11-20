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

    //鑾峰彇鎵�鏈夌暀瑷�
    @RequestMapping(value = "/getcomment",method = RequestMethod.POST)
    public Object getComment(@RequestParam("appid") String appid){
        log.info("[鑾峰彇鎵�鏈夌暀瑷�]---->>>>>star<<<<<----");
        return commentService.getAllCommentByAppid(appid);
    }

    //鍒犻櫎鎸囧畾鐣欒█
    @RequestMapping(value = "/delcomment",method = RequestMethod.POST)
    public Object delComment(@RequestParam("uuid") String uuid){
        log.info("[鍒犻櫎鎸囧畾鐣欒█]---->>>>>star<<<<<----");
        return commentService.delCommentByUuid(uuid);
    }

    //淇敼鐣欒█鐘舵��
    @RequestMapping(value = "/updatecomment",method = RequestMethod.POST)
    public Object updateComment(@RequestParam("uuid") String uuid){
        log.info("[淇敼鐣欒█鐘舵�乚---->>>>>star<<<<<----");
        return commentService.updateCommentFlag(uuid);
    }

    //鑾峰彇缁撳淇℃伅
    @RequestMapping(value = "/getmaininfo",method = RequestMethod.POST)
    public Object getMainInfo(){
        log.info("[鑾峰彇缁撳淇℃伅]---->>>>>star<<<<<----");
        return mainInfoService.getAllMainInfo();
    }

    //淇敼璇锋煬鍩虹淇℃伅
    @RequestMapping(value = "/updatemaininfo",method = RequestMethod.POST)
    public Object updateMainInfo(@RequestBody String req){
        log.info("[淇敼璇锋煬鍩虹淇℃伅]---->>>>>star<<<<<----");
        Map map = (Map) JSONObject.parse(req);
        return mainInfoService.updateByMap(map);
    }

    //鏌ヨ鍑哄腑淇℃伅
    @RequestMapping(value = "/getchat",method = RequestMethod.POST)
    public Object getChat(@RequestParam("appid") String appid){
        log.info("[鏌ヨ鍑哄腑淇℃伅]---->>>>>star<<<<<----");
        return chatService.getChatByAppid(appid);
    }

    //鏌ヨ鎵�鏈夌浉鍐�
    @RequestMapping(value = "/getphotos",method = RequestMethod.POST)
    public Object getPhotos(@RequestParam("appid")String appid){
        log.info("[鏌ヨ鎵�鏈夌浉鍐宂---->>>>>star<<<<<----");
        return photosService.getPhotosByAppid(appid);
    }

    //鍒犻櫎鎸囧畾鐓х墖
    @RequestMapping(value = "/delphotos",method = RequestMethod.POST)
    public Object delPhotoByAppid(@RequestParam("appid")String appid,@RequestParam("pid")String pid){
        log.info("[鍒犻櫎鎸囧畾鐓х墖]---->>>>>star<<<<<----");
        return photosService.delPhotoByid(appid,pid);
    }

    //涓婁紶鏂囦欢
    @RequestMapping("/upload")
    public ImgResult uplpad(MultipartFile file, HttpServletRequest request) {
        log.info("[涓婁紶鏂囦欢]---->>>>>star<<<<<----");
        String desFilePath = "";
        String oriName = "";
        ImgResult result = new ImgResult();
        Map<String, String> dataMap = new HashMap<>();
        ImgResult imgResult = new ImgResult();
        try {
            // 1.鑾峰彇鍘熸枃浠跺悕
            oriName = file.getOriginalFilename();
            String fileName =oriName.substring(oriName.lastIndexOf("\\")+1,oriName.lastIndexOf("."));
            // 2.鑾峰彇鍘熸枃浠跺浘鐗囧悗缂�锛屼互鏈�鍚庣殑.浣滀负鎴彇(.jpg)
            String extName = oriName.substring(oriName.lastIndexOf("."));
            // 3.鐢熸垚鑷畾涔夌殑鏂版枃浠跺悕锛岃繖閲屼互UUID.jpg|png|xxx浣滀负鏍煎紡锛堝彲閫夋搷浣滐紝涔熷彲浠ヤ笉鑷畾涔夋柊鏂囦欢鍚嶏級
            String uuid = UUID.randomUUID().toString();
            String newName = uuid + extName;
            // 4.鑾峰彇瑕佷繚瀛樼殑璺緞鏂囦欢澶�
            String realPath = request.getRealPath("imgs");
            // 5.淇濆瓨
            desFilePath = realPath + "//" + newName;
            File desFile = new File(desFilePath);
            file.transferTo(desFile);
            // 6.杩斿洖淇濆瓨缁撴灉淇℃伅
            result.setCode(0);
            dataMap = new HashMap<>();
            dataMap.put("src", "webapp/imgs/" + newName);
            result.setData(dataMap);
            result.setMsg(oriName + "涓婁紶鎴愬姛锛�");
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

    //璁剧疆涓婚〉
    @RequestMapping("/setmain")
    public Object setMain(@RequestParam("appid")String appid,@RequestParam("pid")String pid){
        log.info("[璁剧疆涓婚〉鐓х墖]---->>>>>star<<<<<----");
        Object value = photosService.getPhotosByAppid(appid, pid);
        return mainInfoService.setMainPhoto(appid,(String)value);
    }
}
