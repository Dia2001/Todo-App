package sbjp.rest.sbjprestful.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "groupmember")
public class GroupMember implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "groupmember_id", length = 11)
	private int id;
	

	@Column(name = "user_id", length = 11, nullable = false, insertable = false, updatable = false)
	private int userId;
	
	@Column(name = "group_id", length = 11, nullable = false, insertable = false, updatable = false)
	private int groupId;
	

	public GroupMember() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "GroupMember [id=" + id + ", user=" + userId + ", group=" + groupId + "]";
	}

}
