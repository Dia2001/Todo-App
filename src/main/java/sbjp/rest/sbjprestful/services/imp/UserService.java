package sbjp.rest.sbjprestful.services.imp;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import sbjp.rest.sbjprestful.clientsever.request.UserRequest;
import sbjp.rest.sbjprestful.converter.UserConverter;
import sbjp.rest.sbjprestful.entities.User;
import sbjp.rest.sbjprestful.enums.RoleEnum;
import sbjp.rest.sbjprestful.repositories.IUserRepository;
import sbjp.rest.sbjprestful.services.IUserService;

@Component
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	//@Autowired
	//private UserConverter userConverter;

	@Override
	public List<User> getAllUser() {
		List<User> users =userRepository.findAll();
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	@Transactional
	public boolean add(UserRequest request) {
		
		User check = null;
		User user = new User();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setRole("ROLE_USER");
		
		check = userRepository.save(user);
		return check != null ? true : false;
	}

	@Override
	@Transactional
	public boolean update(int userId,UserRequest request) {
		User check=null;
		User user=userRepository.getById(userId);
		if(Objects.nonNull(user)) {
			user.setEmail(request.getEmail());
			user.setPassword(request.getPassword());
			user.setRole("ROLE_USER");
			check = userRepository.save(user);
		}
		return check != null ? true : false;
	}

	@Override
	public User findById(int id) {
		return userRepository.getById(id);
	}

}
