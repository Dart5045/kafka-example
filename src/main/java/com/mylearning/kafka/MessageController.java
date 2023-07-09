package com.mylearning.kafka;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    private final KafkaTemplate<String, Message> kafkaTemplate;

    public MessageController(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping()
    public void publishMessage(
            @RequestBody MessageRequest request
    )
    {
        Message message = new Message(
                request.message(),
                LocalDateTime.now()
        );
        kafkaTemplate.send("mylearning",message);
    }
}
