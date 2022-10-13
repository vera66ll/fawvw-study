package com.py.springboot_database.controller.producer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.py.springboot_database.entity.Message.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;


@Component
@Slf4j
@RestController
public class producecontroller {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private Gson gson = new GsonBuilder().create();
    @RequestMapping("/send")
    public String send(){
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("--------message={}" + gson.toJson(message));
        kafkaTemplate.send("topic1", gson.toJson(message));
        return "success";

    }

}
