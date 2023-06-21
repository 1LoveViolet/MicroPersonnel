package com.group.microPersonnel.service;

import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.domain.ProExp;
import java.util.List;

public interface ProExpService {
    Result<ProExp> insertProExp(ProExp proexp);
    Result<ProExp> updateProExpById(ProExp proexp);
    Result<ProExp> deleteProExpById(int id);
    Result<ProExp> getProExpById(int id);
    List<ProExp> getProExp();
    List<ProExp> mochaProExp(String param1);
}
