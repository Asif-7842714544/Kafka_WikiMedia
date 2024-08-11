package com.Asif.Producer.Producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class WikiMediaProducer {


    private final KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage( String message) {
        CompletableFuture<SendResult<String, String>> send = kafkaTemplate.send("wikimedia-stream", message);
        log.info("Sending message to Asif-Topic {}", message);
    }
}
