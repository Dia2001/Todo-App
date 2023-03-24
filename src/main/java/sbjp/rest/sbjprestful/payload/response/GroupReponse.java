package sbjp.rest.sbjprestful.payload.response;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class GroupReponse {

	private int id;
	
	private String title;
	
	private String name;
	
	private Set<UserReponse> users;
	
}
