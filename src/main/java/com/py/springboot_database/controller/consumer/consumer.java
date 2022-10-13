package com.py.springboot_database.controller.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class consumer {
    @KafkaListener(topics = "topic1")
    public void listen(ConsumerRecord<?,?> record){
        Optional<?> kafkamessage = Optional.ofNullable(record.value());
        if(kafkamessage.isPresent()){
            Object message = kafkamessage.get();
            log.info("----------record=" + record);
            log.info("----------message=" + message);
        }
    }
}
