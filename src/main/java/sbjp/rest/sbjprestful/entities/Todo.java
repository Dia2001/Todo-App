package sbjp.rest.sbjprestful.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import sbjp.rest.sbjprestful.enums.TokenType;

@Entity
@Table(name = "todo")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Todo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "todo_id", length = 11)
	private int id;

	@Column(name = "title", length = 100, nullable = false)
	private String title;

	@Column(name = "description", length = 500, nullable = false)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", columnDefinition = "DATE DEFAULT CURRENT_DATE", nullable = false)
	private Date createdDate;

	protected void onCreate() { createdDate = new Date(); }

	@Column(name = "updated_date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@Column(name = "delete_date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletedDate;

	@Column(name = "start_date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Column(name = "end_date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@Column(name = "completed", length = 500, nullable = false)
	private Boolean completed;

	@Column(name = "link_id", length = 500, nullable = false)
	private int linkId;

	@Column(name = "type", length = 500, nullable = false)
	private int type;

}
