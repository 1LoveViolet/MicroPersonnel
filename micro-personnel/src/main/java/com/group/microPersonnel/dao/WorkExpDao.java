package com.group.microPersonnel.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.domain.WorkExp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface WorkExpDao extends BaseMapper<WorkExp> {
    @Select("select * from work_exp where firm like CONCAT('%',#{param1},'%') or post like CONCAT('%',#{param1},'%') " +
            "or start_date like CONCAT('%',#{param1},'%') or end_date like CONCAT('%',#{param1},'%')")
    List<WorkExp> mochaWorkExp(String param1);
}
