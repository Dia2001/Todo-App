package sbjp.rest.sbjprestful.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sbjp.rest.sbjprestful.entities.Todo;
import sbjp.rest.sbjprestful.payload.request.TodoRequest;
import sbjp.rest.sbjprestful.payload.response.TodoReponse;

@Component
public class TodoConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Todo converToEntity(TodoRequest todoRequest) {
		Todo todo = modelMapper.map(todoRequest, Todo.class);
		return todo;
	}
	
	
	public TodoReponse converToResponse(Todo todo) {
		TodoReponse todoReponse = modelMapper.map(todo, TodoReponse.class);
		return todoReponse;
	}
	
}
