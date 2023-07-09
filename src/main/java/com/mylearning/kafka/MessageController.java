package com.mylearning.kafka;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    private final KafkaTemplate kafkaTemplate;

    public MessageController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @PostMapping
    public void publish(
            @RequestBody MessageRequest request
    )
    {
        kafkaTemplate.send("mylearning",request.message());

    }
}
