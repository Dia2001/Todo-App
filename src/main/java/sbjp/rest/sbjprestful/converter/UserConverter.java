package sbjp.rest.sbjprestful.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sbjp.rest.sbjprestful.clientsever.request.UserRequest;
import sbjp.rest.sbjprestful.clientsever.response.UserReponse;
import sbjp.rest.sbjprestful.entities.User;

@Component
public class UserConverter {
	
	@Autowired
	private  ModelMapper modelMapper;

	public UserReponse converToModel(User userEntity) {

		UserReponse user = modelMapper.map(userEntity, UserReponse.class);
		return user;
	}

}
