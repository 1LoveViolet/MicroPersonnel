package com.group.microPersonnel.controller;

import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.domain.Contact;
import com.group.microPersonnel.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    /**
     * 127.0.0.1/contact/insert ---- post
     * {"type":"qq11", "content":"11123"}
     */
    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Contact> insertContact(@RequestBody Contact contact) {
        return contactService.insertContact(contact);
    }


    /**
     * 127.0.0.1/contact/update ---- put
     * {"id":"2","type":"qq11", "content":"1112"}
     */
    @PutMapping(value="/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Contact> updateContactById(@RequestBody Contact contact) {

        return contactService.updateContactById(contact);
    }


    /**
     * 127.0.0.1/contact/delete/2 ---- delete
     */
    @DeleteMapping(value = "/delete/{id}")
    public Result<Contact> deleteContactById(@PathVariable int id) {

        return contactService.deleteContactById(id);
    }


    /**
     * 127.0.0.1/contact/get/2 ---- get
     */
    @GetMapping(value = "/get/{id}")
    public Result<Contact> getCertificateById(@PathVariable int id){
        return contactService.getContactById(id);
    }

    /**
     * 127.0.0.1/contact/get ---- get
     */
    @GetMapping(value = "/get")
    public List<Contact> getContact() {

        return contactService.getContact();
    }


    /**
     * 127.0.0.1/contact/mocha/ ---- get
     */
    @GetMapping(value = "/mocha/{param1}")
    public List<Contact> mochaContact(@PathVariable String param1){
        return contactService.mochaContact(param1);
    }
}
