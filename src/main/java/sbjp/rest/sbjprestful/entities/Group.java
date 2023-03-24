package sbjp.rest.sbjprestful.entities;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sbjp.rest.sbjprestful.enums.TokenType;

@Entity
@Table(name = "groupp")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Group implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", length = 11)
	private int id;
	
	@Column(name = "title", length = 50, nullable = false)
	private String title;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "groups", fetch = FetchType.EAGER)
	private Set<User> users;
	
}
