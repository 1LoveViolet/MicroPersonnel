package com.group.microPersonnel.service.impl;

import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.dao.ContactDao;
import com.group.microPersonnel.domain.Contact;
import com.group.microPersonnel.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service

public class ContactServiceImpl implements ContactService {


    @Autowired
    private ContactDao contactDao;
    @Override
    public Result<Contact> insertContact(Contact contact) {
        // 初始化 user 某些属性
        contact.setUpdateTime(LocalDateTime.now());
        contact.setCreateDate(LocalDateTime.now());
        // 插入 certificate
        contactDao.insert(contact);
        // 返回结果
        return Result.ok();
    }


    @Override
    public Result<Contact> updateContactById(Contact contact) {
        // 初始化 user 相关属性
        contact.setUpdateTime(LocalDateTime.now());
        // 进行更新操作
        contactDao.updateById(contact);
        // 返回正确的结果
        return Result.ok();
    }

    @Override
    public Result<Contact> deleteContactById(int id) {
        contactDao.deleteById(id);
        return Result.ok();
    }

    @Override
    public Result<Contact> getContactById(int id) {
        return Result.ok(contactDao.selectById(id));
    }

    @Override
    public List<Contact> getContact() {
        return contactDao.selectList(null);
    }

    @Override
    public List<Contact> mochaContact(String param1) {
        return contactDao.mochaContact(param1);
    }
}
