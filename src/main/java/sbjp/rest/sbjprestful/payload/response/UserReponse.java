package sbjp.rest.sbjprestful.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UserReponse {
	
	private int id;
	
	private String userName;
	
	private String password;
	
	private String role;

	
}

	
