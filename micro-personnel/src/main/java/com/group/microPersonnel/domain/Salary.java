package com.group.microPersonnel.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String department;
    private int basicSalary;
    private int fullAttendancePay;
    private int lateDeduction;
    private int leaveDeduction;
    private int performanceBonus;

}
