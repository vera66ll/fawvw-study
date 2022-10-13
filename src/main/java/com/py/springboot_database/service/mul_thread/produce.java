package com.py.springboot_database.service.mul_thread;

import com.py.springboot_database.model.dto.JpaUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*生产者：生产对象为JpaUserDTO
 * 可以假设一个用户注册*/
public class produce extends Thread {
    //    定义属性
    private synContainer containner;
    private JpaUserDTO jpaUserDTO;
    //    构造器
    public produce(JpaUserDTO jpaUserDTO, synContainer containner){
        this.jpaUserDTO = jpaUserDTO;
        this.containner = containner;
    }
    //    方法：生产
    @Override
    public void run(){
        containner.register(jpaUserDTO);
        System.out.println(jpaUserDTO.getUsername().toString() + "用户注册了");
    }
}

