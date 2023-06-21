package com.group.microPersonnel.service;

import com.group.microPersonnel.domain.BasicInformation;
import com.group.microPersonnel.common.vo.Result;

import java.util.List;

public interface BasicInformationService {
    Result<BasicInformation> insertBasicInformation(BasicInformation basicInformation);
    Result<BasicInformation> updateBasicInformationById(BasicInformation basicInformation);
    Result<BasicInformation> getBasicInformationById(int id);
    List<BasicInformation> getBasicInformation();
}
