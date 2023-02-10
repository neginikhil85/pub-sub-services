package com.learning.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Service
public class HealthCheckService {

    private String message;

    public String checkHealth() {
        if(Objects.nonNull(message)) {
            return message;
        } else {
            return "no message published for health";
        }
    }

    @ServiceActivator(inputChannel = "inputChannel")
    public void receiveMessage(String payload) {
        this.message = payload;
    }
}
