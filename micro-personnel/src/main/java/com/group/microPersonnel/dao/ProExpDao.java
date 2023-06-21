package com.group.microPersonnel.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.microPersonnel.domain.ProExp;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProExpDao extends BaseMapper<ProExp> {
    @Select("select * from pro_exp where duty like CONCAT('%',#{param1},'%') or project_name like CONCAT('%',#{param1},'%') " +
            "or start_date like CONCAT('%',#{param1},'%') or end_date like CONCAT('%',#{param1},'%')")
    List<ProExp> mochaProExp(String param1);
}
