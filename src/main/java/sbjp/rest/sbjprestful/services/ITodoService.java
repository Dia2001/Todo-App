package sbjp.rest.sbjprestful.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sbjp.rest.sbjprestful.clientsever.request.TodoRequest;
import sbjp.rest.sbjprestful.entities.Todo;


@Service
public interface ITodoService {
	List<Todo> getAll();
	boolean add(TodoRequest request);
	boolean update(int todoId,TodoRequest request);
	Todo findById(int id);
	boolean delete(int todoId);
}
