package com.group.microPersonnel.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.microPersonnel.domain.Contact;
import com.group.microPersonnel.domain.EduInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * dao层
 */
@Repository
@Mapper
public interface EduInfoDao extends BaseMapper<EduInfo> {
    @Select("select * from edu_info where profession like CONCAT('%',#{param1},'%') or school like CONCAT('%',#{param1},'%')")
    List<EduInfo> mochaEduInfo(String param1);
}
