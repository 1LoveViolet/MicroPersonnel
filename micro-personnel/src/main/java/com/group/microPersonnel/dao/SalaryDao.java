package com.group.microPersonnel.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.microPersonnel.domain.Salary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface SalaryDao extends BaseMapper<Salary> {
    @Select("select * from salary where name like CONCAT('%',#{param1},'%') or department like CONCAT('%',#{param1},'%') " +
            "or basic_salary like CONCAT('%',#{param1},'%') or full_attendance_pay like CONCAT('%',#{param1},'%')" +
            "or late_deduction like CONCAT('%',#{param1},'%') or performance_bonus like CONCAT('%',#{param1},'%')" +
            "or leave_deduction like CONCAT('%',#{param1},'%')")
    List<Salary> mochaSalary(String param1);
}

