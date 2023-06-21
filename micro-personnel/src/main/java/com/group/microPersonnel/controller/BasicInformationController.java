package com.group.microPersonnel.controller;

import com.group.microPersonnel.domain.BasicInformation;
import com.group.microPersonnel.service.BasicInformationService;
import com.group.microPersonnel.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/basicInformation")
public class BasicInformationController {

    @Autowired
    private BasicInformationService basicInformationService;

    /**
     * 127.0.0.1/basicInformation/insert ---- post
     * {"name":"hjh12", "gender":"家11","birthday":"2018-08-02","height":"5551"
     * ,"weight":"5551","nationality":"5551","nativePlace":"5551","graduateSchool":"5551"
     * ,"headPicture":"5551","selfEvaluation":"5551"}
     */
    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<BasicInformation> insertBasicInformation(@RequestBody BasicInformation basicInformation) {
        return basicInformationService.insertBasicInformation(basicInformation);
    }


    /**
     * 127.0.0.1/basicInformation/update ---- put
     * {"id":"2","name":"hjh11", "gender":"家11","birthday":"2018-08-02","height":"5551"
     * ,"weight":"5551","nationality":"5551","nativePlace":"5551","graduateSchool":"5551"
     * ,"headPicture":"5551","selfEvaluation":"5551"}
     */
    @PutMapping(value="/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<BasicInformation> updateBasicInformationById(@RequestBody BasicInformation basicInformation) {

        return basicInformationService.updateBasicInformationById(basicInformation);
    }

    /**
     * 127.0.0.1/basicInformation/get ---- get
     */
    @GetMapping(value = "/get")
    public List<BasicInformation> getBasicInformation() {
        return basicInformationService.getBasicInformation();
    }
    /**
     * 127.0.0.1/basicInformation/get/1 ---- get
     *
     */
    @GetMapping(value = "/get/{id}")
    public Result<BasicInformation> getBasicInformationById(@PathVariable int id){
        return basicInformationService.getBasicInformationById(id);
    }
}
