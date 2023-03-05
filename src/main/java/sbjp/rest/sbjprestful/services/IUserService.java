package sbjp.rest.sbjprestful.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sbjp.rest.sbjprestful.clientsever.request.UserRequest;
import sbjp.rest.sbjprestful.entities.User;

@Service
public interface IUserService {
	List<User> getAllUser();
	boolean add(UserRequest request);
	boolean update(int userId,UserRequest request);
	User findByUserName();
}
