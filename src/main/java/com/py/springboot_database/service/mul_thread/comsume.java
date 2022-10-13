package com.py.springboot_database.service.mul_thread;

import com.py.springboot_database.model.dto.JpaUserDTO;
import org.springframework.stereotype.Service;

/*消费者：消费对象为JpaUserDTO
* 假设一个对象注册后，需要把数据同步到数据库*/
public class comsume extends Thread{
    private synContainer container;
    private JpaUserDTO jpaUserDTO;
    public comsume(synContainer container){
        this.container = container;
    }
    @Override
    public void run(){
        JpaUserDTO user = container.push();
        System.out.println("已经记录了" + user.getUsername().toString());
    }
}
