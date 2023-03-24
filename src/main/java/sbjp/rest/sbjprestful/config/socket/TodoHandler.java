package sbjp.rest.sbjprestful.config.socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import sbjp.rest.sbjprestful.payload.request.TodoRequest;
import sbjp.rest.sbjprestful.services.TodoService;


@Slf4j
public class TodoHandler extends TextWebSocketHandler {
    @Autowired
    TodoService todoService;
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TodoRequest todoRequest = mapper.readValue(message.getPayload(), TodoRequest.class);
        todoService.updateCompleted(todoRequest);
        String json = mapper.writeValueAsString(todoRequest);
        session.sendMessage(new TextMessage(json));
    }
}
