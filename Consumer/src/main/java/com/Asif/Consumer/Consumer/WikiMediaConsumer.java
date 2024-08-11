package com.Asif.Consumer.Consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WikiMediaConsumer {

    @KafkaListener(topics = "wikimedia-stream",groupId = "my-group")
    public void consumeMsg(String message) {
        log.info("Consumed message: {}", message);
    }
}
