package sbjp.rest.sbjprestful.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import sbjp.rest.sbjprestful.config.socket.SocketTextHandler;
import sbjp.rest.sbjprestful.config.socket.SyncTodoHandler;
import sbjp.rest.sbjprestful.config.socket.TodoHandler;


@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(syncTodoHandler(), "/syncTodoHandler");
        webSocketHandlerRegistry.addHandler(todoHandler(), "/todoHandler");
        webSocketHandlerRegistry.addHandler(socketTextHandler(), "/user");
    }

    @Bean
    public SocketTextHandler socketTextHandler() {
        return new SocketTextHandler();
    }
    @Bean
    public SyncTodoHandler syncTodoHandler() {
        return new SyncTodoHandler();
    }
    @Bean
    public TodoHandler todoHandler() {
        return new TodoHandler();
    }
}
