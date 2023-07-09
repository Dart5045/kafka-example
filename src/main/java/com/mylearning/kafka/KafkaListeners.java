package com.mylearning.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
             topics = "mylearning",
            groupId = "groupId"
    )
    void listener(String data){
        System.out.println("Listener received "+ data + " ");
    }
}
