package sbjp.rest.sbjprestful.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sbjp.rest.sbjprestful.entities.Group;
import sbjp.rest.sbjprestful.payload.request.GroupRequest;
import sbjp.rest.sbjprestful.payload.response.GroupReponse;

@Service
public interface GroupService {
	List<GroupReponse> getAll();
	boolean add(GroupRequest request);
	boolean update(int idGroup,GroupRequest request);
	Group findById(int id);
	boolean delete(int idGroup);
}
