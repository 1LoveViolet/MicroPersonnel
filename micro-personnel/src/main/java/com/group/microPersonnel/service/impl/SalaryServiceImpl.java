package com.group.microPersonnel.service.impl;

import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.dao.ProExpDao;
import com.group.microPersonnel.dao.SalaryDao;
import com.group.microPersonnel.domain.Salary;
import com.group.microPersonnel.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryDao salaryDao;

    @Override
    public Result<Salary> insertSalary(Salary salary) {
        salaryDao.insert(salary);
        return Result.ok();
    }

    @Override
    public Result<Salary> updateSalaryById(Salary salary) {
        salaryDao.updateById(salary);
        return Result.ok();
    }

    @Override
    public Result<Salary> deleteSalaryById(int id) {
        salaryDao.deleteById(id);
        return Result.ok();
    }

    @Override
    public Result<Salary> getSalaryById(int id) {
        return Result.ok(salaryDao.selectById(id));
    }

    @Override
    public List<Salary> getSalary() {
        return salaryDao.selectList(null);
    }

    @Override
    public List<Salary> mochaSalary(String param1) {
        return salaryDao.mochaSalary(param1);
    }
}
