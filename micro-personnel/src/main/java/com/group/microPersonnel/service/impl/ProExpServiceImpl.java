package com.group.microPersonnel.service.impl;

import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.dao.ProExpDao;
import com.group.microPersonnel.domain.ProExp;
import com.group.microPersonnel.service.ProExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProExpServiceImpl implements ProExpService {
    @Autowired
    private ProExpDao proExpDao;
    @Override
    public Result<ProExp> insertProExp(ProExp proexp) {
        proExpDao.insert(proexp);
        return Result.ok();
    }

    @Override
    public Result<ProExp> updateProExpById(ProExp proexp) {
        proExpDao.updateById(proexp);
        return Result.ok();
    }

    @Override
    public Result<ProExp> deleteProExpById(int id) {
        proExpDao.deleteById(id);
        return Result.ok();
    }

    @Override
    public Result<ProExp> getProExpById(int id) {
        return Result.ok(proExpDao.selectById(id));
    }

    @Override
    public List<ProExp> getProExp() {
        return proExpDao.selectList(null);
    }

    @Override
    public List<ProExp> mochaProExp(String param1) {
        return proExpDao.mochaProExp(param1);
    }
}
