package sbjp.rest.sbjprestful.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import sbjp.rest.sbjprestful.converter.TodoConverter;
import sbjp.rest.sbjprestful.entities.Todo;
import sbjp.rest.sbjprestful.payload.request.TodoRequest;
import sbjp.rest.sbjprestful.payload.response.TodoReponse;
import sbjp.rest.sbjprestful.repositories.TodoRepository;
import sbjp.rest.sbjprestful.services.TodoService;
import sbjp.rest.sbjprestful.services.UserService;

@Component
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;

	@Autowired
	private TodoConverter todoConverter;

	@Autowired
	private UserService userService;
	
	@Override
	public List<TodoReponse> getAll() {
		List<TodoReponse> list = todoRepository.findAllByLinkId(userService.findByUserName().getId()).stream()
				.map(item -> todoConverter.converToResponse((Todo) item)).collect(Collectors.toList());
		return list;
	}

	@Override
	@Transactional
	public boolean add(TodoRequest request) {
		System.out.println(request.toString());
		Todo check = null;
		Todo todo = todoConverter.converToEntity(request);
		todo.setCompleted(false);
		todo.setCreatedDate(new Date());
		todo.setLinkId(request.getLink_id());
		todo.setType(request.getType());

		check = todoRepository.save(todo);
		return check != null ? true : false;
	}

	@Override
	@Transactional
	public boolean update(int todoId, TodoRequest request) {

		Todo check = null;
		Todo todo = todoRepository.getById(todoId);
		if (Objects.nonNull(todo)) {
			todo.setTitle(request.getTitle());
			todo.setDescription(request.getDescription());
			todo.setUpdatedDate(new Date());
			todo.setStartDate(request.getStartDate());
			todo.setEndDate(request.getEndDate());
			todo.setCompleted(request.getCompleted());
			check = todoRepository.save(todo);
		}
		return check != null ? true : false;
	}

	@Override
	public boolean updateCompleted(TodoRequest request) {
		System.out.println("dô"+request.toString());
		Todo check = null;
		Todo todo = todoRepository.findOneById(request.getId());
		if (Objects.nonNull(todo)) {
			System.out.println(todo.toString());
			todo.setCompleted(request.getCompleted());
			check = todoRepository.save(todo);
			System.out.println("thành côn g hay thất bại"+check);
		}
		return check != null ? true : false;
	}

	@Override
	public Todo findById(int id) {
		Todo todo=null;
		if(todoRepository.findById(id).isPresent()) {
			todo=todoRepository.findById(id).get();
		}
		return todo;
	}

	@Override
	@Transactional
	public boolean delete(int todoId) {
		boolean check = false;
		if(todoRepository.findById(todoId).isPresent()) {
			Todo todo = todoRepository.findById(todoId).get();
			try {
				todoRepository.delete(todo);
				check = true;
			} catch (Exception e) {
				check = false;
			}
		}
		return check;
	}

	@Override
	public TodoReponse getById(int id) {
		TodoReponse todoReponse=null;
		if(todoRepository.findById(id).isPresent()) {
			todoReponse=todoConverter.converToResponse(todoRepository.findById(id).get());
		}
		return todoReponse;
	}

	

}
