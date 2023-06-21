package com.group.microPersonnel.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.group.microPersonnel.common.entity.AbstractEntity;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
public class Address extends AbstractEntity {
        private String name;
        private String alias;
        private String details;
        private int zipCode;
    }
