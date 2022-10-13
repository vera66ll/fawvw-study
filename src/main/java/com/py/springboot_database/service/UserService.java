package com.py.springboot_database.service;

import com.py.springboot_database.dao.jpa.JpaUserRepository;
import com.py.springboot_database.model.dto.JpaUserDTO;
import com.py.springboot_database.model.entity.jpa.JpaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
@Service
public class UserService {
    @Autowired
    private JpaUserRepository jpaUserRepository;
    @Autowired
    private dto_po_convert dtoPoConvert;
    public JpaUserDTO addUser(long id, String username, String mobile, String email, String password) {
        JpaUserDTO jpaUserDTO = new JpaUserDTO();
        jpaUserDTO.setId(id);
        jpaUserDTO.setUsername(username);
        jpaUserDTO.setMobile(mobile);
        jpaUserDTO.setPassword(password);
        jpaUserDTO.setEmail(email);
        return jpaUserDTO;
    }
    public String saveUser(JpaUserDTO jpaUserDTO){
        JpaUser jpaUser = dtoPoConvert.JpaUserdtoconvertJpaUser(jpaUserDTO);
        jpaUserRepository.save(jpaUser);
        return "save success";
    }
    public String changepassword(JpaUserDTO jpaUserDTO){
        String password = jpaUserDTO.getPassword();
        jpaUserRepository.changepassword(password);
        return "change sucess";
    }
    public boolean verify(String mobile){
        if(mobile==null){
            return false;
        }
        JpaUser userbyMobile = jpaUserRepository.findByMobile(mobile);
        if(userbyMobile==null){
            return false;
        }else{
            return true;
        }
    }
}
