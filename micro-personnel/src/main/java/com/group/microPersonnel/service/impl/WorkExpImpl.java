package com.group.microPersonnel.service.impl;

import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.dao.WorkExpDao;
import com.group.microPersonnel.domain.WorkExp;
import com.group.microPersonnel.service.WorkExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkExpImpl implements WorkExpService {

    @Autowired
    private WorkExpDao workExpDao;
    @Override
    @Transient
    public Result<WorkExp> insertWorkExp(WorkExp workexp) {
        workexp.setStartDate(LocalDate.now());
        workexp.setEndDate(LocalDate.now());
        workExpDao.insert(workexp);
        return Result.ok();
    }

    @Override
    @Transient
    public Result<WorkExp> updateWorkExpById(WorkExp workExp) {
        workExpDao.updateById(workExp);
        return Result.ok();
    }
    @Override
    @Transient
    public Result<WorkExp> deleteWorkExpById(int id) {
        workExpDao.deleteById(id);
        return Result.ok();
    }

    @Override
    public Result<WorkExp> getWorkExpById(int id) {
        return Result.ok(workExpDao.selectById(id));
    }

    @Override
    public List<WorkExp> getWorkExp() {
        return workExpDao.selectList(null);
    }
    @Override
    public List<WorkExp> mochaWorkExp(String param1) {
        return workExpDao.mochaWorkExp(param1);
    }
}
