package com.group.microPersonnel.service;

import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.domain.WorkExp;

import java.util.List;

public interface WorkExpService {
    Result<WorkExp> insertWorkExp(WorkExp workexp);
    Result<WorkExp> updateWorkExpById(WorkExp workExp);
    Result<WorkExp> deleteWorkExpById(int id);
    Result<WorkExp> getWorkExpById(int id);
    List<WorkExp> getWorkExp();
    List<WorkExp> mochaWorkExp(String param1);
}
