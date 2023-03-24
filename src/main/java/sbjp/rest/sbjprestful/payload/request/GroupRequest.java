package sbjp.rest.sbjprestful.payload.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class GroupRequest {
	
	private String title;
	
	private String name;
	
	private List<UserRequest> userRequests;
	
}
