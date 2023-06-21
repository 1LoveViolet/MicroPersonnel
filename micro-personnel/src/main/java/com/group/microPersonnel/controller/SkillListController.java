package com.group.microPersonnel.controller;

import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.domain.SkillList;
import com.group.microPersonnel.service.SkillListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/skillList")
public class SkillListController {
    @Autowired
    private SkillListService skillListService;

    /**
     * 127.0.0.1/skillList/insert ---- post
     * {"proficiency":"11", "skillName":"无"}
     */
    @PostMapping(value="/insert",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<SkillList> insertSkillList(@RequestBody SkillList skillList){
        return skillListService.insertSkillList(skillList);
    }


    /**
     * 127.0.0.1/skillList/update ---- put
     * {"1d":"3","proficiency":"222", "skillName":"张三"}
     *
     */
    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<SkillList> updateSkillListById(@RequestBody SkillList skillList){
        return skillListService.updateSkillListById(skillList);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Result<SkillList> deleteSkillListById(@PathVariable int id){
        return skillListService.deleteSkillListById(id);
    }

    @GetMapping(value = "/get/{id}")
    public Result<SkillList> getSkillListById(@PathVariable int id){
        return skillListService.getSkillListById(id);
    }

    @GetMapping(value = "/get")
    public List<SkillList> getSkillList(){
        return skillListService.getSkillList();
    }

    @GetMapping(value = "/mocha/{param1}")
    public List<SkillList> mochaSkillList(@PathVariable String param1){
        return skillListService.mochaSkillList(param1);
    }
}
