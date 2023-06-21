package com.group.microPersonnel.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class SkillList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String skillName;
    private int useDate;
    private int proficiency;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate buildDate;
}
