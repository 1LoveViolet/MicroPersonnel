package com.group.microPersonnel.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.group.microPersonnel.common.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
public class Contact extends AbstractEntity {
    private String type;
    private String content;
}
