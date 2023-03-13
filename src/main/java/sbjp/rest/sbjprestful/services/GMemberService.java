package sbjp.rest.sbjprestful.services;

import org.springframework.stereotype.Service;

import sbjp.rest.sbjprestful.payload.request.GMemberRequest;

@Service
public interface GMemberService {
	boolean add(int groupId,GMemberRequest grRequest);
}
