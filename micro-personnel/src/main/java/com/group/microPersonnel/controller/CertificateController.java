package com.group.microPersonnel.controller;
import com.group.microPersonnel.domain.Certificate;
import com.group.microPersonnel.service.CertificateService;
import com.group.microPersonnel.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/certificate")
public class CertificateController {
    @Autowired
    private CertificateService certificateService;

    /**
     * 127.0.0.1/certificate/insert ---- post
     * {"name":"hjh", "type":"身份证","number":"111","issDate":"2017-08-02","validityPeriod":"2018-08-02"}
     */
    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Certificate> insertCertificate(@RequestBody Certificate certificate) {
        return certificateService.insertCertificate(certificate);
    }
    /**
     * 127.0.0.1/certificate/update ---- put
     * {"id":2, "name":"hjh11", "type":"身份证","number":"11122","issDate":"2020-08-02","validityPeriod":"2020-08-02"}
     */
    @PutMapping(value="/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Certificate> updateCertificateById(@RequestBody Certificate certificate) {
        return certificateService.updateCertificateById(certificate);
    }
    /**
     * 127.0.0.1/certificate/delete/2 ---- delete
     */
    @DeleteMapping(value = "/delete/{id}")
    public Result<Certificate> deleteCertificateById(@PathVariable int id) {
    return certificateService.deleteCertificateById(id);
    }

    /**
     * 127.0.0.1/certificate/get/2 ---- get
     */
    @GetMapping(value = "/get/{id}")
    public Result<Certificate> getCertificateById(@PathVariable int id){
        return certificateService.getCertificateById(id);
    }

    /**
     * 127.0.0.1/certificate/get ---- get
     */
    @GetMapping(value = "/get")
    public List<Certificate> getCertificate() {
        return certificateService.getCertificate();
    }
    /**
     * 127.0.0.1/certificate/mocha/ ---- get
     */
    @GetMapping(value = "/mocha/{param1}")
    public List<Certificate> mochaCertificate(@PathVariable String param1){
        return certificateService.mochaCertificate(param1);
    }
}
