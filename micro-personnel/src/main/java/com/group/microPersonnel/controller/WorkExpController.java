package com.group.microPersonnel.controller;

import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.domain.User;
import com.group.microPersonnel.domain.WorkExp;
import com.group.microPersonnel.service.WorkExpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@RestController
@RequestMapping("/workexp")
public class WorkExpController {
    @Autowired
    private WorkExpService workExpService;
    @PostMapping(value="/insert",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<WorkExp> insertWorkExp(@RequestBody WorkExp workexp){
        return workExpService.insertWorkExp(workexp);
    }

    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<WorkExp> updateWorkExpById(HttpServletRequest request,@RequestBody WorkExp workexp){
        return workExpService.updateWorkExpById(workexp);
    }

//    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
//    public Result<String> update(HttpServletRequest request,@RequestBody User user){
//        Long empId = (Long)request.getSession().getAttribute("userid");
//        //employee.setUpdateTime(LocalDateTime.now());
//        //employee.setUpdateUser(empId);
//        userService.updateById(user);
//
//        return Result.ok("员工信息修改成功");
//    }



    @DeleteMapping(value = "/delete/{id}")
    public Result<WorkExp> deleteWorkExpById(@PathVariable int id){
        return workExpService.deleteWorkExpById(id);
    }

    @GetMapping(value = "/get/{id}")
    public Result<WorkExp> getWorkExpById(@PathVariable int id){
        return workExpService.getWorkExpById(id);
    }

    @GetMapping(value = "/get")
    public List<WorkExp> getWorkExp() {
        return workExpService.getWorkExp();
    }
    @GetMapping(value = "/mocha/{param1}")
    public List<WorkExp> mochaWorkExp(@PathVariable String param1){
        return workExpService.mochaWorkExp(param1);
    }
}
