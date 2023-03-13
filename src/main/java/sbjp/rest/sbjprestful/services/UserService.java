package sbjp.rest.sbjprestful.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sbjp.rest.sbjprestful.entities.Todo;
import sbjp.rest.sbjprestful.entities.User;
import sbjp.rest.sbjprestful.payload.request.UserRequest;
import sbjp.rest.sbjprestful.payload.response.UserReponse;

@Service
public interface UserService {
	List<UserReponse> getAllUser();
	boolean add(UserRequest request);
	boolean update(int userId,UserRequest request);
	boolean delete(int id);
	User findByUserName();
	User findById(int id);
}
