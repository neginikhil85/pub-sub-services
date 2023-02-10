package com.learning.controller;

import com.learning.gateway.OutboundChannel;
import com.learning.service.HealthStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/health")
public class HealthStatusController {

    private final HealthStatusService service;

    @PostMapping("/publish/status")
    public String publishHealthStatus() {
       return service.healthStatus();
    }
}
