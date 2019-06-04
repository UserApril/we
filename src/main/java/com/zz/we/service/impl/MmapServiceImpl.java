package com.zz.we.service.impl;

import com.zz.we.dto.Mmap;
import com.zz.we.dto.MmapExample;
import com.zz.we.mapper.MmapMapper;
import com.zz.we.response.Resp_map;
import com.zz.we.service.MmapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MmapServiceImpl implements MmapService {
    @Autowired
    public MmapMapper mmapMapper;

    public Object getMapByAppid(String appid){
        Resp_map resp_map =new Resp_map();
        MmapExample mmapExample =new MmapExample();
        mmapExample.createCriteria().andAppidEqualTo(appid);
        List<Mmap> mmaps = mmapMapper.selectByExample(mmapExample);
        if(mmaps.size()>0){
            resp_map.setMainInfo(mmaps.get(0));
        }
        return resp_map;
    }
}
