package com.group.microPersonnel.controller;
import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.domain.ProExp;
import com.group.microPersonnel.service.ProExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proexp")
public class ProExpController {
    @Autowired
    private ProExpService proExpService;

    @PostMapping(value="/insert",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<ProExp> insertProExp(@RequestBody ProExp proexp){
        return proExpService.insertProExp(proexp);
    }

    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<ProExp> updateProExpById(@RequestBody ProExp proexp){
        return proExpService.updateProExpById(proexp);
    }
    @DeleteMapping(value = "/delete/{id}")
    public Result<ProExp> deleteProExpById(@PathVariable int id){
        return proExpService.deleteProExpById(id);
    }

    @GetMapping(value = "/get/{id}")
    public Result<ProExp> getProExpById(@PathVariable int id){
        return proExpService.getProExpById(id);
    }
    @GetMapping(value = "/get")
    public List<ProExp> getProExp() {
        return proExpService.getProExp();
    }


    @GetMapping(value = "/mocha/{param1}")
    public List<ProExp> mochaProExp(@PathVariable String param1){
        return proExpService.mochaProExp(param1);
    }
}
