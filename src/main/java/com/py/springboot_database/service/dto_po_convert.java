package com.py.springboot_database.service;

import com.py.springboot_database.model.dto.JpaUserDTO;
import com.py.springboot_database.model.entity.jpa.JpaUser;
import org.springframework.stereotype.Service;

@Service
public class dto_po_convert {
    public JpaUserDTO JpaUserconvertJpaUserdto(JpaUser jpaUser) {
        if(jpaUser==null){
            return null;
        }
        JpaUserDTO jpaUserDTO = new JpaUserDTO();
        jpaUserDTO.setUsername(jpaUser.getUsername());
        jpaUserDTO.setId(jpaUser.getId());
        jpaUserDTO.setMobile(jpaUser.getMobile());
        jpaUserDTO.setEmail(jpaUser.getEmail());
        return jpaUserDTO;
    }
    public JpaUser JpaUserdtoconvertJpaUser(JpaUserDTO jpaUserDTO) {
        if(jpaUserDTO==null){
            return null;
        }
        JpaUser jpaUser = new JpaUser();
        jpaUser.setUsername(jpaUserDTO.getUsername());
        jpaUser.setId(jpaUserDTO.getId());
        jpaUser.setMobile(jpaUserDTO.getMobile());
        jpaUser.setEmail(jpaUserDTO.getEmail());
        jpaUser.setPassword(jpaUserDTO.getPassword());
        return jpaUser;
    }
}
