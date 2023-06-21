package com.group.microPersonnel.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.microPersonnel.domain.Certificate;
import com.group.microPersonnel.domain.Contact;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ContactDao extends BaseMapper<Contact> {
    @Select("select * from contact where content like CONCAT('%',#{param1},'%') or type like CONCAT('%',#{param1},'%') " +
            "or type like CONCAT('%',#{param1},'%')")
    List<Contact> mochaContact(String param1);
}
