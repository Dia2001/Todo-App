package sbjp.rest.sbjprestful.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sbjp.rest.sbjprestful.common.Utils;
import sbjp.rest.sbjprestful.entities.User;
import sbjp.rest.sbjprestful.payload.request.UserRequest;
import sbjp.rest.sbjprestful.payload.response.UserReponse;

@Component
public class UserConverter {
	
	@Autowired
	private  ModelMapper modelMapper;

	public UserReponse converToReponse(User userEntity) {

		UserReponse user = modelMapper.map(userEntity, UserReponse.class);
		return user;
	}
	public User converToRequest(UserRequest userRequest) {

		User user = modelMapper.map(userRequest, User.class);
		user.setPassword(Utils.passwordEncoder().encode(user.getPassword()));
		return user;
	}
}
