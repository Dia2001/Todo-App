package sbjp.rest.sbjprestful.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sbjp.rest.sbjprestful.entities.Todo;
import sbjp.rest.sbjprestful.payload.request.TodoRequest;
import sbjp.rest.sbjprestful.payload.request.TodoSearchRequest;
import sbjp.rest.sbjprestful.payload.response.TodoReponse;


@Service
public interface TodoService {
	List<TodoReponse> getAll();
	boolean add(TodoRequest request);
	boolean update(int todoId,TodoRequest request);
	Todo findById(int id);
	boolean delete(int todoId);
	TodoReponse getById(int id);
}
