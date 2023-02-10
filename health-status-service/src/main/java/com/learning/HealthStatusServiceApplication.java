package com.learning;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.outbound.PubSubMessageHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;

@SpringBootApplication
public class HealthStatusServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthStatusServiceApplication.class, args);
	}

}
