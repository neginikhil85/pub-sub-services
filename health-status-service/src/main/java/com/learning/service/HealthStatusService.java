package com.learning.service;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.outbound.PubSubMessageHandler;
import com.learning.gateway.OutboundChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class HealthStatusService {

    private final OutboundChannel gateway;
    public String healthStatus() {
        RestTemplate restTemplate = new RestTemplate();
        String healthUrl = "http://localhost:8082/actuator/health";
        String response = restTemplate.getForObject(healthUrl, String.class);
        gateway.sendMessageToPubSub(response);
        return "health status published to pub sub Successfully";
    }

}
