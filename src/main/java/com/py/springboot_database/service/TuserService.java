package com.py.springboot_database.service;

import com.py.springboot_database.dao.mybatis.TuserMapper;
import com.py.springboot_database.model.entity.mybatis.Tuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TuserService {
    private TuserMapper tuserMapper;
    public Tuser selectByUserName(String username){
        Tuser tuser = tuserMapper.selectByUserName(username);
        System.out.println(tuser.toString());
        return tuser;
    }
}
