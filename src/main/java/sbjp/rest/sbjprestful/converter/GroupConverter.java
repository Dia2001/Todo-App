package sbjp.rest.sbjprestful.converter;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sbjp.rest.sbjprestful.clientsever.response.GroupReponse;
import sbjp.rest.sbjprestful.entities.Group;
import sbjp.rest.sbjprestful.entities.User;
import sbjp.rest.sbjprestful.clientsever.response.*;

@Component
public class GroupConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserConverter userConverter;
	
	public GroupReponse converViewModel(Group groupEntity) {
		GroupReponse groupReponse=new GroupReponse();
		groupReponse.setId(groupEntity.getId());
		groupReponse.setName(groupEntity.getName());
		groupReponse.setTitle(groupEntity.getTitle());
		
		Set<UserReponse> users=new HashSet<>();
		for(User user: groupEntity.getUsers()) {
			UserReponse userReponse=new UserReponse();
			userReponse=userConverter.converToModel(user);
			users.add(userReponse);
		}
		groupReponse.setUsers(users);
		
		return groupReponse;
	}
}
