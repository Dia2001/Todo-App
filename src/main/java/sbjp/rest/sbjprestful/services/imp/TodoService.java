package sbjp.rest.sbjprestful.services.imp;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import sbjp.rest.sbjprestful.clientsever.request.TodoRequest;
import sbjp.rest.sbjprestful.entities.Todo;
import sbjp.rest.sbjprestful.entities.User;
import sbjp.rest.sbjprestful.enums.TypeRoleEnum;
import sbjp.rest.sbjprestful.repositories.ITodoRepository;
import sbjp.rest.sbjprestful.repositories.IUserRepository;
import sbjp.rest.sbjprestful.services.ITodoService;

@Component
public class TodoService implements ITodoService{

	@Autowired
	private ITodoRepository todoRepository;
	
	@Override
	public List<Todo> getAll() {
		List<Todo> todos=todoRepository.findAll();
		return todos;
	}
	
	@Override
	@Transactional
	public boolean add(TodoRequest request) {
		Todo check = null;
		
		Todo todo = new Todo();
		todo.setTitle(request.getTitle());
		todo.setDescription(request.getDescription());
		todo.setUpdatedDate(request.getUpdatedDate());
		todo.setDeletedDate(request.getDeletedDate());
		todo.setStartDate(request.getStartDate());
		todo.setEndDate(request.getEndDate());
		todo.setCompleted(request.getCompleted());
		todo.setLinkid(1); // id của user nào thì user đó mới được cập nhật
		todo.setType(TypeRoleEnum.Type_User.getRoleValue());
		
		check = todoRepository.save(todo);
		return check != null ? true : false;
	}

	@Override
	@Transactional
	public boolean update(int todoId, TodoRequest request) {
		
		Todo check=null;
		Todo todo=todoRepository.getById(todoId);
		
		// security đảm bảo răng user đó đang đăng nhập thì mới cho xóa
		// Đầu tiên kiểm tra xem user đó tự lên todo hay ở trong group
		if(todo.getType().equals(TypeRoleEnum.Type_User.getRoleValue())) {
			// Nếu nó mà của user thì mình sẽ lọc theo cái id user đang đăng nhập và cái id của todo và cái type
			// Sau đó sẽ sửa
			todo=todoRepository.findOneByIdAndLinkIdAndType(todoId,1,TypeRoleEnum.Type_User.getRoleValue());// chú ý sửa userId
			if(Objects.nonNull(todo)) {
				todo.setTitle(request.getTitle());
				todo.setDescription(request.getDescription());
				todo.setUpdatedDate(new Date());
				todo.setStartDate(request.getStartDate());
				todo.setEndDate(request.getEndDate());
				todo.setCompleted(request.getCompleted());
				check=todoRepository.save(todo);
			}
		}else {
			// nếu nó mà ở trong group thì chỉ có chủ group mới được thêm và sửa công việc
		}
		return check != null ? true : false;
	}

	@Override
	public Todo findById(int id) {
		return todoRepository.findOneByIdAndLinkId(id, 1);// nhớ cái id của user
	}

	@Override
	@Transactional
	public boolean delete(int todoId) {
		boolean check=false;
		Todo todo=todoRepository.findOneByIdAndLinkId(todoId,1);
		try {
			todoRepository.delete(todo);
			check=true;
		} catch (Exception e) {
			// TODO: handle exception
			check=false;
		}
		return check ;
	}


}
