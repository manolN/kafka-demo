package com.example.kafkaDemo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic exampleTopic() {
        return TopicBuilder.name("example")
                .build();
    }

    @Bean
    public NewTopic exampleTopic2() {
        return TopicBuilder.name("example2")
                .build();
    }
}
