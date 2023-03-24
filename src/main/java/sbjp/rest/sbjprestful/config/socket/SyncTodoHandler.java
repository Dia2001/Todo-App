package sbjp.rest.sbjprestful.config.socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import sbjp.rest.sbjprestful.payload.response.TodoReponse;
import sbjp.rest.sbjprestful.services.TodoService;

import java.io.IOException;
import java.util.List;


@Slf4j
public class SyncTodoHandler extends TextWebSocketHandler {
    @Autowired
    TodoService todoService;
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException, InterruptedException {

        String payload = message.getPayload();
        ObjectMapper mapper = new ObjectMapper();

        if (payload.equals("get_all_todos")) {
            List<TodoReponse> products = todoService.getAll();
            String json = mapper.writeValueAsString(products);
            session.sendMessage(new TextMessage(json));
        } else if (payload.startsWith("get_todo_by_id:")) {
            int id = Integer.parseInt(payload.substring(15));
            TodoReponse todo = todoService.getById(id);
            String json = mapper.writeValueAsString(todo);
            session.sendMessage(new TextMessage(json));
        }

    }
}
