package com.group.microPersonnel.service;

import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.domain.EduInfo;
import com.group.microPersonnel.domain.ProExp;
import com.group.microPersonnel.domain.SkillList;

import java.util.List;

public interface SkillListService {
    Result<SkillList> insertSkillList(SkillList skillList);
    Result<SkillList> updateSkillListById(SkillList skillList);
    Result<SkillList> deleteSkillListById(int id);
    Result<SkillList> getSkillListById(int id);
    List<SkillList> getSkillList();
    List<SkillList> mochaSkillList(String param1);
}
