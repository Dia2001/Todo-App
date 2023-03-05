package sbjp.rest.sbjprestful.clientsever.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class NotificationResponse {
	
	private String msg;

	private boolean check;

	
	public NotificationResponse() {
		super();
	}


	public NotificationResponse(String msg, boolean check) {
		super();
		this.msg = msg;
		this.check = check;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public boolean isCheck() {
		return check;
	}


	public void setCheck(boolean check) {
		this.check = check;
	}


	@Override
	public String toString() {
		return "NotificationResponse [msg=" + msg + ", check=" + check + "]";
	}
	
}
