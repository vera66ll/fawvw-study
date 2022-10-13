package com.py.springboot_database.controller;

import antlr.StringUtils;
import com.py.springboot_database.dao.jpa.JpaUserRepository;
import com.py.springboot_database.model.dto.JpaUserDTO;
import com.py.springboot_database.model.entity.jpa.JpaUser;
import com.py.springboot_database.service.UserService;
import com.py.springboot_database.service.dto_po_convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class usercontroller {
    @Autowired
    private UserService userService;
    @Autowired
    private JpaUserRepository jpaUserRepository;
    @Autowired
    private dto_po_convert dtoPoConvert;
    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String adduser(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("mobile") String mobile, @RequestParam("email") String email, @RequestParam("password") String password){
        JpaUserDTO jpaUserDTO = userService.addUser(id, name, mobile, email, password);
        String  signal = userService.saveUser(jpaUserDTO);
        return signal;
    }
//返回前端的是dto对象
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String find(@RequestParam("id")long id){
        JpaUser userbyId = jpaUserRepository.findById(id);
        if(userbyId==null){
            return "没有查找到该用户，请重新输入";
        }
        JpaUserDTO jpaUserDTO = dtoPoConvert.JpaUserconvertJpaUserdto(userbyId);
        return jpaUserDTO.toString();
    }
    @RequestMapping(value = "/findbyusername", method = RequestMethod.GET)
    public String findbyId(@RequestParam("username") String username){
        JpaUser userbyusername = jpaUserRepository.findByUsername(username);
        if(userbyusername==null){
            return "没有查找到该用户，请重新输入";
        }
        JpaUserDTO jpaUserDTO = dtoPoConvert.JpaUserconvertJpaUserdto(userbyusername);
        return jpaUserDTO.toString();
    }
    @RequestMapping(value = "/count")
    public long count(){
        return jpaUserRepository.count();
    }
        @RequestMapping(value="/changepassword", method = RequestMethod.GET)
    public String changepassword(@RequestParam("username") String username, @RequestParam("mobile") String mobile, @RequestParam("password") String password){
//       验证用户是否存在
        if(!userService.verify(mobile)){
            return "用户不存在,请重新输入信息";
        }
        JpaUser userbyMobile = jpaUserRepository.findByMobile(mobile);
        JpaUserDTO jpaUserDTO = userService.addUser(userbyMobile.getId(),userbyMobile.getUsername(),userbyMobile.getMobile(),userbyMobile.getEmail(),password);
        String response = userService.changepassword(jpaUserDTO);
        return response;
    }
}
