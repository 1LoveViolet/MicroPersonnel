package com.group.microPersonnel.controller;

import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.domain.Salary;
import com.group.microPersonnel.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;
    /**
     * 127.0.0.1/salary/insert ---- post
     * {"name":"hjh11", "department":"技术","basicSalary":"1000","fullAttendancePay":"2000",
     * "lateDeduction":"300","leaveDeduction":"400","performanceBonus":"100"}
     */
    @PostMapping(value="/insert",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Salary> insertSalary(@RequestBody Salary salary){
        return salaryService.insertSalary(salary);
    }

    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Salary> updateSalaryById(@RequestBody Salary salary){
        return salaryService.updateSalaryById(salary);
    }
    @DeleteMapping(value = "/delete/{id}")
    public Result<Salary> deleteSalaryById(@PathVariable int id){
        return salaryService.deleteSalaryById(id);
    }

    @GetMapping(value = "/get/{id}")
    public Result<Salary> getSalaryById(@PathVariable int id){
        return salaryService.getSalaryById(id);
    }

    @GetMapping(value = "/get")
    public List<Salary> getSalary() {
        return salaryService.getSalary();
    }


    @GetMapping(value = "/mocha/{param1}")
    public List<Salary> mochaSalary(@PathVariable String param1){
        return salaryService.mochaSalary(param1);
    }
}