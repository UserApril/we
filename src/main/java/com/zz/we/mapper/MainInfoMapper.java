package com.zz.we.mapper;

import com.zz.we.dto.MainInfo;
import com.zz.we.dto.MainInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MainInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mainInfo
     *
     * @mbg.generated Wed May 22 18:29:57 CST 2019
     */
    long countByExample(MainInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mainInfo
     *
     * @mbg.generated Wed May 22 18:29:57 CST 2019
     */
    int deleteByExample(MainInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mainInfo
     *
     * @mbg.generated Wed May 22 18:29:57 CST 2019
     */
    int insert(MainInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mainInfo
     *
     * @mbg.generated Wed May 22 18:29:57 CST 2019
     */
    int insertSelective(MainInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mainInfo
     *
     * @mbg.generated Wed May 22 18:29:57 CST 2019
     */
    List<MainInfo> selectByExample(MainInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mainInfo
     *
     * @mbg.generated Wed May 22 18:29:57 CST 2019
     */
    int updateByExampleSelective(@Param("record") MainInfo record, @Param("example") MainInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mainInfo
     *
     * @mbg.generated Wed May 22 18:29:57 CST 2019
     */
    int updateByExample(@Param("record") MainInfo record, @Param("example") MainInfoExample example);
}