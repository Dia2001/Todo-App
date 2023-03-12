package sbjp.rest.sbjprestful.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sbjp.rest.sbjprestful.entities.GroupMember;
import sbjp.rest.sbjprestful.payload.request.GMemberRequest;

@Component
public class GroupMemberConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public GroupMember converToEntity(GMemberRequest gMemberRequest) {
		GroupMember gMember = modelMapper.map(gMemberRequest, GroupMember.class);
		return gMember;
	}
}
