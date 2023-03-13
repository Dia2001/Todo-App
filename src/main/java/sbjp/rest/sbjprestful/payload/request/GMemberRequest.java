package sbjp.rest.sbjprestful.payload.request;

public class GMemberRequest {


	private int userId;

	public GMemberRequest() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "GMemberRequest [userId=" + userId + "]";
	}

	

}
