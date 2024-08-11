package com.Asif.Consumer.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class WikiMediaTopicConfig {
    @Bean
    public NewTopic wikiMediaStreamTopic() {
        return TopicBuilder
                .name("wikimedia-stream")
                .partitions(4)
                .replicas(1)
                .build();
    }
}
