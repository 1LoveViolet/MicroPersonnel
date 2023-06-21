package com.group.microPersonnel.service.impl;


import com.group.microPersonnel.dao.BasicInformationDao;
import com.group.microPersonnel.domain.BasicInformation;
import com.group.microPersonnel.service.BasicInformationService;
import com.group.microPersonnel.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class BasicInformationServiceImpl implements BasicInformationService {

    @Autowired
    private BasicInformationDao basicInformationDao;
    @Override
    public Result<BasicInformation> insertBasicInformation(BasicInformation basicInformation) {
        basicInformation.setUpdateTime(LocalDateTime.now());
        basicInformation.setCreateDate(LocalDateTime.now());
        // 插入 certificate
        basicInformationDao.insert(basicInformation);
        // 返回结果
        return Result.ok();
    }
    @Override
    @Transactional
    public Result<BasicInformation> updateBasicInformationById(BasicInformation basicInformation) {
        basicInformation.setUpdateTime(LocalDateTime.now());
        // 进行更新操作
        basicInformationDao.updateById(basicInformation);
        // 返回正确的结果
        return Result.ok();
    }
    @Override
    public List<BasicInformation> getBasicInformation() {
        return basicInformationDao.selectList(null);
    }
    @Override
    public Result<BasicInformation> getBasicInformationById(int id) {
        return Result.ok(basicInformationDao.selectById(id));
    }
}
