package com.Asif.Producer.Stream;

import com.Asif.Producer.Producer.WikiMediaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikiMediaStreamConsumer {

    private final WebClient webClient;
    private final WikiMediaProducer producer;

    public WikiMediaStreamConsumer(WebClient.Builder webClientBuilder, WikiMediaProducer producer) {
        this.webClient = webClientBuilder
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
        this.producer = producer;
    }

    public void consumeStreamAndPublish(){
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(producer::sendMessage);
    }
}
