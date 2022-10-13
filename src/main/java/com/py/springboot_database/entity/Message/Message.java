package com.py.springboot_database.entity.Message;

import lombok.Data;

import java.util.Date;

@Data
public class Message {

        private Long id;    //id

        private String msg; //消息

        private Date sendTime;  //时间戳
}
