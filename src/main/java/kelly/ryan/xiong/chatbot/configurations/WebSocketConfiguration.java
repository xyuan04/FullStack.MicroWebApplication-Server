package kelly.ryan.xiong.chatbot.configurations;

import kelly.ryan.xiong.chatbot.handler.ChatWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        List<String> endPoints = Arrays.asList("/Channel/*");
        endPoints.forEach(endPoint -> {
            webSocketHandlerRegistry
                    .addHandler(getChatWebSocketHandler(), endPoint)
                    .setAllowedOrigins("*");
        });

    }

    @Bean
    public WebSocketHandler getChatWebSocketHandler() {
        return new ChatWebSocketHandler();
    }
}
