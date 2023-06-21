package com.group.microPersonnel.service.impl;

import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.dao.EduInfoDao;
import com.group.microPersonnel.domain.EduInfo;
import com.group.microPersonnel.service.EduInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EduInfoServiceImpl implements EduInfoService {

    @Autowired
    private EduInfoDao eduInfoDao;
    @Override
    @Transient
    public Result<EduInfo> insertEduInfo(EduInfo eduInfo) {
        eduInfoDao.insert(eduInfo);
        return Result.ok();
    }
    @Override
    @Transient
    public Result<EduInfo> updateEduInfoById(EduInfo eduInfo){
        eduInfoDao.updateById(eduInfo);
        return  Result.ok();
    }

    @Override
    @Transient
    public Result<EduInfo> deleteEduInfoById(int id){
        eduInfoDao.deleteById(id);
        return Result.ok();

    }

    @Override
    public Result<EduInfo> getEduInfoById(int id) {
        return Result.ok(eduInfoDao.selectById(id));
    }

    @Override
    public List<EduInfo> getEduInfo() {
        return eduInfoDao.selectList(null);
    }

    @Override
    public List<EduInfo> mochaEduInfo(String param1) {
        return eduInfoDao.mochaEduInfo(param1);
    }

}
