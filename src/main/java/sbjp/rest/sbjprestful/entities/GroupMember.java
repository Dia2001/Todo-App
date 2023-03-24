package sbjp.rest.sbjprestful.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sbjp.rest.sbjprestful.enums.TokenType;
@Entity
@Table(name = "groupmember")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
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
	
	@Column(name = "type",nullable = false)
	private int type;
	
	@ManyToOne
	@JoinColumn(name = "group_id", nullable = false)
	private Group group;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
}
