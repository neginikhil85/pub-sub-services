package com.learning.gateway;

import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(name = "myHealthStatusGateway", defaultRequestChannel = "outboundMsgChannel")
public interface OutboundChannel {

    void sendMessageToPubSub(String message);
}
