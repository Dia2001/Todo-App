package sbjp.rest.sbjprestful.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserRequest {

	private int id;

	private String userName;

	private String password;
	
	private String role;

}
