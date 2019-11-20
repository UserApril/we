package com.zz.we.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("/input")
    public void test(){
        kafkaTemplate.send("topic_input","info");
    }

    @KafkaListener(id = "group",topics = "topic_input")
    public void listener(String output){
        System.out.println("output:"+output);
    }
}
