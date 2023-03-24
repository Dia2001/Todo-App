package sbjp.rest.sbjprestful.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class NotificationResponse {
	
	private String msg;

	private boolean check;
	
}
