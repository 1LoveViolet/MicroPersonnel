package com.group.microPersonnel.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.microPersonnel.domain.Address;
import com.group.microPersonnel.domain.WorkExp;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AddressDao extends BaseMapper<Address> {
    @Select("select * from address where alias like CONCAT('%',#{param1},'%') or details like CONCAT('%',#{param1},'%') " +
            "or name like CONCAT('%',#{param1},'%') or zip_code like CONCAT('%',#{param1},'%')")
    List<Address> mochaAddress(String param1);
}
