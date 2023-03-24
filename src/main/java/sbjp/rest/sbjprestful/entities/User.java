package sbjp.rest.sbjprestful.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sbjp.rest.sbjprestful.enums.TokenType;

@Entity
@Table(name = "userr")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false)
	private int id;
	
	@Column(name = "username", unique = true, nullable = false, length = 20)
	private String userName;
	
	@Column(name = "password", nullable = false, length = 100)
	private String password;

	@Column(name = "role", length = 20, nullable = false)
	private String role;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "groupmember", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false), inverseJoinColumns = {
			@JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false, updatable = false) })
	private Set<Group> groups = new HashSet<>();

}
