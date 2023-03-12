package sbjp.rest.sbjprestful.payload.request;

public class UserRequest {

	private int id;

	private String userName;

	private String password;
	
	private String role;

	public UserRequest() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRequest [id=" + id + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}



}
