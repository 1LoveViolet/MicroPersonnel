package com.group.microPersonnel.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.microPersonnel.domain.SkillList;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface SkillListDao extends BaseMapper<SkillList> {
    @Select("select * from skill_list where skill_name like CONCAT('%',#{param1},'%') or use_date like CONCAT('%',#{param1},'%') " +
            "or proficiency like CONCAT('%',#{param1},'%') or build_date like CONCAT('%',#{param1},'%')")
    List<SkillList> mochaSkillList(String param1);
}
