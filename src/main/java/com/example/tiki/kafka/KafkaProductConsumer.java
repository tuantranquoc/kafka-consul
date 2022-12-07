package com.example.tiki.kafka;

import com.example.tiki.common.EnumKafkaTopic;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaProductConsumer {
    @KafkaListener(topics = "NEW_PRODUCT", groupId = "tiki", containerFactory = "listenerEventSendStringMessage")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
