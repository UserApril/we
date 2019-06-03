package com.zz.we.mapper;

import com.zz.we.dto.Mmap;
import com.zz.we.dto.MmapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MmapMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table map
     *
     * @mbg.generated Mon Jun 03 17:58:49 CST 2019
     */
    long countByExample(MmapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table map
     *
     * @mbg.generated Mon Jun 03 17:58:49 CST 2019
     */
    int deleteByExample(MmapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table map
     *
     * @mbg.generated Mon Jun 03 17:58:49 CST 2019
     */
    int insert(Mmap record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table map
     *
     * @mbg.generated Mon Jun 03 17:58:49 CST 2019
     */
    int insertSelective(Mmap record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table map
     *
     * @mbg.generated Mon Jun 03 17:58:49 CST 2019
     */
    List<Mmap> selectByExample(MmapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table map
     *
     * @mbg.generated Mon Jun 03 17:58:49 CST 2019
     */
    int updateByExampleSelective(@Param("record") Mmap record, @Param("example") MmapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table map
     *
     * @mbg.generated Mon Jun 03 17:58:49 CST 2019
     */
    int updateByExample(@Param("record") Mmap record, @Param("example") MmapExample example);
}