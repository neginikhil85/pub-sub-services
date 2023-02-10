package com.learning.config;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.outbound.PubSubMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;

@Configuration
public class PubSubConfig {

    @Bean
    @ServiceActivator(inputChannel = "outboundMsgChannel")
    public PubSubMessageHandler messageHandler(PubSubTemplate pubSubTemplate){
        return new PubSubMessageHandler(pubSubTemplate, "CheckHealth");
    }
}
