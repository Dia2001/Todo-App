package sbjp.rest.sbjprestful.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sbjp.rest.sbjprestful.clientsever.request.GroupRequest;
import sbjp.rest.sbjprestful.clientsever.response.GroupReponse;
import sbjp.rest.sbjprestful.entities.Group;

@Service
public interface IGroupService {
	List<GroupReponse> getAll();
	boolean add(GroupRequest request);
	boolean update(int idGroup,GroupRequest request);
	Group findById(int id);
	boolean delete(int idGroup);
}
