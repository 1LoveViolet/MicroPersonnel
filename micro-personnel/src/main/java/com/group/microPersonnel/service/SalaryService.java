package com.group.microPersonnel.service;

import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.domain.Salary;
import java.util.List;

public interface SalaryService {

    Result<Salary> insertSalary(Salary salary);
    Result<Salary> updateSalaryById(Salary salary);
    Result<Salary> deleteSalaryById(int id);
    Result<Salary> getSalaryById(int id);
    List<Salary> getSalary();
    List<Salary> mochaSalary(String param1);
}
