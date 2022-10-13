package com.py.springboot_database.service.mul_thread;

import com.py.springboot_database.model.dto.JpaUserDTO;
import com.py.springboot_database.model.entity.jpa.JpaUser;
import com.py.springboot_database.service.TuserService;
import com.py.springboot_database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
@Service
/*缓冲区：用于存储生产者生产的产品和消费者需要消费的产品*/
public class synContainer {
//    容器,一次只能同时容纳10个人注册
    JpaUserDTO[] jpaUserDTOS = new JpaUserDTO[10];
//    标志
    int count = 0;
//    用户注册
    public synchronized void register(JpaUserDTO jpaUserDTO){
//        如果容器满了，需要通知消费者消费，即把用户记入数据库
        while(count==jpaUserDTOS.length){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
//        如果容器没有满，继续注册
        jpaUserDTOS[count] = jpaUserDTO;
        count++;
//        通知消费者消费
        this.notifyAll();
    }
    public synchronized JpaUserDTO push(){
        UserService userService = ApplicationContextUtil.getContext().getBean(UserService.class);
//        如果没有用户了，通知生产者应该注册了
        while(count<=0){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
//        消费:把注册的用户记录入数据表
        count--;
        JpaUserDTO jpaUserDTO = jpaUserDTOS[count];
        userService.saveUser(jpaUserDTO);
//        通知生产者
        this.notifyAll();
        return jpaUserDTOS[count];
    }
}
