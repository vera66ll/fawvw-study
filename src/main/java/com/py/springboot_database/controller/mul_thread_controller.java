package com.py.springboot_database.controller;

import com.py.springboot_database.model.dto.JpaUserDTO;
import com.py.springboot_database.service.UserService;
import com.py.springboot_database.service.mul_thread.comsume;
import com.py.springboot_database.service.mul_thread.produce;
import com.py.springboot_database.service.mul_thread.synContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mul_thread_controller {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("mobile") String mobile, @RequestParam("email") String email, @RequestParam("password") String password){
        JpaUserDTO jpaUserDTO = userService.addUser(id, name, mobile, email, password);
        synContainer container = new synContainer();
        produce pro = new produce(jpaUserDTO, container);
        comsume com = new comsume(container);
        pro.start();
        com.start();
        return "mul_sucess";
    }

}
