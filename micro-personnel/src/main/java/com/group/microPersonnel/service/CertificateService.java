package com.group.microPersonnel.service;

import com.group.microPersonnel.domain.Address;
import com.group.microPersonnel.domain.Certificate;
import com.group.microPersonnel.common.vo.Result;

import java.util.List;

public interface CertificateService {
    Result<Certificate> insertCertificate(Certificate certificate);
    Result<Certificate> updateCertificateById(Certificate certificate);
    Result<Certificate> deleteCertificateById(int id);
    Result<Certificate> getCertificateById(int id);
    List<Certificate> getCertificate();
    List<Certificate> mochaCertificate(String param1);

}
