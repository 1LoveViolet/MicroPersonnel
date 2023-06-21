package com.group.microPersonnel.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.microPersonnel.domain.User;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.*;

@Repository
@Mapper
public interface UserDao extends BaseMapper<User>{
}
