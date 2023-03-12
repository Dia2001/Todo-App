package sbjp.rest.sbjprestful.services.Impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import sbjp.rest.sbjprestful.common.Utils;
import sbjp.rest.sbjprestful.converter.UserConverter;
import sbjp.rest.sbjprestful.entities.Todo;
import sbjp.rest.sbjprestful.entities.User;
import sbjp.rest.sbjprestful.payload.request.UserRequest;
import sbjp.rest.sbjprestful.payload.response.UserReponse;
import sbjp.rest.sbjprestful.repositories.UserRepository;
import sbjp.rest.sbjprestful.services.UserService;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConverter userConverter;

	@Override
	public List<UserReponse> getAllUser() {
		List<UserReponse> users = userRepository.findAll().stream()
				.map(item -> userConverter.converToReponse((User) item))
				.collect(Collectors.toList());
		return users;
	}

	@Override
	@Transactional
	public boolean add(UserRequest request) {

		User check = null;
		User user = userConverter.converToRequest(request);
		check = userRepository.save(user);
		return check != null ? true : false;
	}


	@Override
	@Transactional
	public User findByUserName() {
		return userRepository.findByuserName(Utils.GetUserName());
	}

	@Override
	@Transactional
	public boolean update(int userId,UserRequest request) {
		User check = null;
		User user = userRepository.getById(userId);
		if (Objects.nonNull(user)) {
			user.setPassword(Utils.passwordEncoder().encode(request.getPassword()));
			check = userRepository.save(user);
		}
		return check != null ? true : false;
	}

	@Override
	public boolean delete(int id) {
		boolean check = false;
		if(userRepository.findById(id).isPresent()) {
			User user =userRepository.findById(id).get();
			try {
				userRepository.delete(user);
				check = true;
			} catch (Exception e) {
				check = false;
			}
		}
		return check;
	}

	@Override
	public User findById(int id) {
		User user=null;
		if(userRepository.findById(id).isPresent()) {
			user=userRepository.findById(id).get();
		}
		return user;
	}

}
