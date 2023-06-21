package com.group.microPersonnel.service.impl;

import com.group.microPersonnel.dao.CertificateDao;
import com.group.microPersonnel.domain.Certificate;
import com.group.microPersonnel.service.CertificateService;
import com.group.microPersonnel.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateDao certificateDao;

    @Override
    @Transactional
    public Result<Certificate> insertCertificate(Certificate certificate) {
// 根据用户名查询用户是否存在，存在返回错误消息，不存在继续插入

        // 初始化 user 某些属性
        certificate.setCreateDate(LocalDateTime.now());
        certificate.setUpdateTime(LocalDateTime.now());
        // 插入 certificate
        certificateDao.insert(certificate);
        // 返回结果
        return Result.ok();
    }

    @Override
    @Transactional
    public Result<Certificate> updateCertificateById(Certificate certificate) {

        // 初始化 user 相关属性
        certificate.setUpdateTime(LocalDateTime.now());
        // 进行更新操作
        certificateDao.updateById(certificate);
        // 返回正确的结果
        return Result.ok();
    }

    @Override
    @Transactional
    public Result<Certificate> deleteCertificateById(int id) {
        certificateDao.deleteById(id);
        return Result.ok();
    }

    @Override
    public Result<Certificate> getCertificateById(int id) {
        return Result.ok(certificateDao.selectById(id));
    }

    @Override
    public List<Certificate> getCertificate() {
        return certificateDao.selectList(null);
    }
    @Override
    public List<Certificate> mochaCertificate(String param1) {
        return certificateDao.mochaCertificate(param1);
    }


}
