package com.py.springboot_database.controller;

import com.py.springboot_database.model.entity.mybatis.Tuser;
import com.py.springboot_database.service.TuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tusercontroller {
    @Autowired
    private TuserService tuserService;
    @RequestMapping(value="/selectbyusername", method = RequestMethod.GET)
    public String selectbyusername(@RequestParam("username") String username){
        Tuser tuser = tuserService.selectByUserName(username);
        return tuser.toString();
    }
}
