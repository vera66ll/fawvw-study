package com.py.springboot_database.model.entity.mybatis;
import lombok.Data;
@Data
public class Tuser {
    private long id;
    private String username;
    private String password;
    private String mobile;
    private String email;
}
