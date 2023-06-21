package com.group.microPersonnel.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.microPersonnel.domain.Address;
import com.group.microPersonnel.domain.Certificate;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CertificateDao extends BaseMapper<Certificate> {
    @Select("select * from certificate where name like CONCAT('%',#{param1},'%') or number like CONCAT('%',#{param1},'%') " +
            "or type like CONCAT('%',#{param1},'%')")
    List<Certificate> mochaCertificate(String param1);
}
