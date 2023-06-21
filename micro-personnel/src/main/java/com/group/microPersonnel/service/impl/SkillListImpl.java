package com.group.microPersonnel.service.impl;

import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.domain.EduInfo;
import com.group.microPersonnel.dao.SkillListDao;
import com.group.microPersonnel.domain.SkillList;
import com.group.microPersonnel.service.SkillListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillListImpl implements SkillListService {
    @Autowired
    private SkillListDao skillListDao;

    @Override
    @Transient
    public Result<SkillList> insertSkillList(SkillList skillList) {
        skillListDao.insert(skillList);
        return Result.ok();
    }
    @Override
    @Transient
    public Result<SkillList> updateSkillListById(SkillList skillList) {
        skillListDao.updateById(skillList);
        return Result.ok();
    }
    @Override
    @Transient
    public Result<SkillList> deleteSkillListById(int id) {
        skillListDao.deleteById(id);
        return Result.ok();
    }

    @Override
    public Result<SkillList> getSkillListById(int id) {
        return Result.ok(skillListDao.selectById(id));
    }

    @Override
    public List<SkillList> getSkillList() {
        return skillListDao.selectList(null);
    }
    @Override
    public List<SkillList> mochaSkillList(String param1) {
        return skillListDao.mochaSkillList(param1);
    }
}
