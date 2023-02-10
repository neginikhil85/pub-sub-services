package com.learning.config;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class PubSubConfig {

    @Bean
    public PubSubInboundChannelAdapter messageAdapter(PubSubTemplate template, @Qualifier("inputChannel") MessageChannel inputChannel) {
        PubSubInboundChannelAdapter channelAdapter = new PubSubInboundChannelAdapter(template, "CheckHealth-sub");
        channelAdapter.setOutputChannel(inputChannel);
        return channelAdapter;
    }

    @Bean
    public MessageChannel inputChannel() {
        return new DirectChannel();
    }
}
