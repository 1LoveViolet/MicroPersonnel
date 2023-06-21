package com.group.microPersonnel.controller;

import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.domain.EduInfo;
import com.group.microPersonnel.service.EduInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eduinfo")
public class EduInfoController {

    @Autowired
    private EduInfoService eduInfoService;
    /**
     * @param eduInfo
     * 127.0.0.1/eduinfo/insert ---- post
     *{"id":1, "startDate":"2021-04-06", "endDate":"2022-03-05","school":"成都大学","profession":"老师"}
     */
    @PostMapping(value="/insert",consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json;charset=UTF-8")
    public Result<EduInfo> insertEduInfo(@RequestBody EduInfo eduInfo) {
        return eduInfoService.insertEduInfo(eduInfo);
    }

    /**
     * @param eduInfo
     * 127.0.0.1/eduinfo/update ---- put
     *{"id":1, "startDate":"2011-11-11", "endDate":"2011-11-22","school":"成都大学1","profession":"老师1"}
     */

    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<EduInfo> updateEduInfoById(@RequestBody EduInfo eduInfo){
        return eduInfoService.updateEduInfoById(eduInfo);
    }
    @DeleteMapping(value = "/delete/{id}")
    public Result<EduInfo> deleteEduInfoById(@PathVariable int id){
        return eduInfoService.deleteEduInfoById(id);
    }


    @GetMapping(value = "/get/{id}")
    public Result<EduInfo> getEduInfoById(@PathVariable int id){
        return eduInfoService.getEduInfoById(id);
    }

    @GetMapping(value = "/get")
    public List<EduInfo> getEduInfo() {
        return eduInfoService.getEduInfo();
    }


    @GetMapping(value = "/mocha/{param1}")
    public List<EduInfo> mochaEduInfo(@PathVariable String param1){
        return eduInfoService.mochaEduInfo(param1);
    }
}
