package com.group.microPersonnel.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.microPersonnel.domain.Address;
import com.group.microPersonnel.domain.BasicInformation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BasicInformationDao extends BaseMapper<BasicInformation> {
//    @Select("select * from basic_information where birthday like CONCAT('%',#{param1},'%') or gender like CONCAT('%',#{param1},'%') " +
//            "or graduate_school like CONCAT('%',#{param1},'%') or name like CONCAT('%',#{param1},'%')" +
//            "or nationality like CONCAT('%',#{param1},'%') or native_place like CONCAT('%',#{param1},'%')")
//    List<Address> mochaBasicInformation(String param1);
}
