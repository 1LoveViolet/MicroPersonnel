package com.group.microPersonnel.service;

import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.domain.Contact;
import com.group.microPersonnel.domain.EduInfo;

import java.util.List;

public interface EduInfoService {
    Result<EduInfo> insertEduInfo(EduInfo eduInfo);
    Result<EduInfo> updateEduInfoById(EduInfo eduInfo);
    Result<EduInfo> deleteEduInfoById(int id);
    Result<EduInfo> getEduInfoById(int id);
    List<EduInfo> getEduInfo();
    List<EduInfo> mochaEduInfo(String param1);
}
