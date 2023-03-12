package sbjp.rest.sbjprestful.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sbjp.rest.sbjprestful.converter.GroupMemberConverter;
import sbjp.rest.sbjprestful.entities.GroupMember;
import sbjp.rest.sbjprestful.payload.request.GMemberRequest;
import sbjp.rest.sbjprestful.repositories.GroupMemberRepository;
import sbjp.rest.sbjprestful.repositories.GroupRepository;
import sbjp.rest.sbjprestful.repositories.UserRepository;
import sbjp.rest.sbjprestful.services.GMemberService;
import sbjp.rest.sbjprestful.services.UserService;

@Component
public class GMemberServiceImpl implements GMemberService {

	@Autowired
	private GroupMemberRepository gMemberRepository;

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	UserService userService;

	@Override
	public boolean add(int groupId, GMemberRequest grRequest) {
		System.out.println(groupId+"aaaaaaaaaaaaa"+grRequest.getUserId());
		boolean result = false;
		
		if (groupRepository.findById(groupId).isPresent()) {
			if (userRepository.findById(grRequest.getUserId()).isPresent()) {
				//if (gMemberRepository.findOneByuserIdAndgroupId(groupId, grRequest.getUserId()) != null) {}  // nhớ làm
				GroupMember check = null;
				GroupMember gMember = new GroupMember();
				gMember.setGroupId(groupId);
				gMember.setUserId(grRequest.getUserId());
				gMember.setType(0);
				gMember.setGroup(groupRepository.getById(groupId));
				gMember.setUser(userRepository.getById(grRequest.getUserId()));
				check = gMemberRepository.save(gMember);
				System.out.println(check+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				result = check != null ? true : false;
			}
		}
		return result;
	}

}
