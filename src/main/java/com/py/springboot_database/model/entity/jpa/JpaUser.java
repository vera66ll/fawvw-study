package com.py.springboot_database.model.entity.jpa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data    //使用lombok
@Entity //通过Entity实现实体类对象映射书库库表
@Table(name="user")  //对应数据库表名
public class JpaUser implements Serializable {
    @Id //标记为主键
    @GeneratedValue  //标记自主自增
    private long id;
    private String username;
    private String password;
    private String mobile;
    private String email;
}
