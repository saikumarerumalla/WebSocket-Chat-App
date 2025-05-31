package com.explore.WebSocket_Chat_App.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    //path for the initial handshake of the application ,endpoint clients use to connect to your WebSocket
    //ws is the WebSocket handshake URL
    //withSockJS() enables fallback options (XHR polling, long-polling) when WebSockets are not supported or fail.
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

    //endpoints when the server listens to
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //This is the prefix clients will use when sending messages to the server (controller).
        //Messages with /app/xyz go to  @MessageMapping methods
        registry.setApplicationDestinationPrefixes("/app");
        //Enables an in-memory message broker to broadcast messages to subscribed clients.
        //Clients subscribe to /topic/abc to receive messages.
        registry.enableSimpleBroker("/topic");
    }

}
