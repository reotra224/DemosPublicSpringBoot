package gn.traore.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurationSupport;

@Configuration
public class WebSocketConfig extends WebSocketMessageBrokerConfigurationSupport {
	

	@Override
	protected void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/socket")
			.setAllowedOrigins("*")
			.withSockJS();
	}

	@Override
	protected void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/socket-subscriber")
				.enableSimpleBroker("/socket-publisher");
	}
	

}
