package com.zz.we.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface ICommentMapper {

    @Update("update comment set flag=#{flag},updateTime=NOW() where uuid=#{uuid}")
    public void updateComment(@Param("uuid")String uuid,@Param("flag")String flag);
}
