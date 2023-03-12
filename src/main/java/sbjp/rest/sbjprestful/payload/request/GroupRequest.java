package sbjp.rest.sbjprestful.payload.request;

import java.util.List;

import jakarta.persistence.Column;

public class GroupRequest {
	
	private String title;
	
	private String name;
	
	private List<UserRequest> userRequests;

	public List<UserRequest> getUserRequests() {
		return userRequests;
	}

	public void setUserRequests(List<UserRequest> userRequests) {
		this.userRequests = userRequests;
	}

	public GroupRequest() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "GroupRequest [title=" + title + ", name=" + name + "]";
	}
	
}
