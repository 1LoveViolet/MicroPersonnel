package com.group.microPersonnel.service;

import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.domain.Certificate;
import com.group.microPersonnel.domain.Contact;

import java.util.List;

public interface ContactService {
    Result<Contact> insertContact(Contact contact);
    Result<Contact> updateContactById(Contact contact);
    Result<Contact> deleteContactById(int id);
    Result<Contact> getContactById(int id);
    List<Contact> getContact();
    List<Contact> mochaContact(String param1);
}
