package com.group.microPersonnel.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.group.microPersonnel.common.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
    public class BasicInformation extends AbstractEntity {
    private String name;
    private String gender;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private int height;
    private int weight;
    private String nationality;
    private String nativePlace;
    private String graduateSchool;
    private String headPicture;
    private String selfEvaluation;

}
