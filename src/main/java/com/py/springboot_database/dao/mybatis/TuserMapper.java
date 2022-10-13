package com.py.springboot_database.dao.mybatis;

import com.py.springboot_database.model.entity.mybatis.Tuser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TuserMapper {
    int deleteByPrimaryKey(long id);
    int insert(Tuser record);
    Tuser selectByPrimaryKey(long id);
    Tuser selectByUserName(String name);
    int updateByPrimaryKeySelective(Tuser record);
}
