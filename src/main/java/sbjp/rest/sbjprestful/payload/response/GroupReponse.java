package sbjp.rest.sbjprestful.payload.response;

import java.util.Set;



public class GroupReponse {

	private int id;
	
	private String title;
	
	private String name;
	
	private Set<UserReponse> users;

	public GroupReponse() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Set<UserReponse> getUsers() {
		return users;
	}

	public void setUsers(Set<UserReponse> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "GroupReponse [id=" + id + ", title=" + title + ", name=" + name + ", users=" + users + "]";
	}
	
	

}
