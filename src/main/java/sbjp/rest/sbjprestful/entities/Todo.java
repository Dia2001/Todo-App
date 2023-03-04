package sbjp.rest.sbjprestful.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import sbjp.rest.sbjprestful.common.Utils;


@Entity
@Table(name = "todo")
public class Todo implements Serializable{
	
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
	@Column(name="created_date",columnDefinition ="DATE DEFAULT CURRENT_DATE",nullable = false)
	private Date createdDate;

	@PrePersist
	protected void onCreate() {
	    createdDate = new Date();
	}
	
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
	private String type;

	public Todo() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	

	public int getLinkid() {
		return linkId;
	}

	public void setLinkid(int linkid) {
		this.linkId = linkid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", description=" + description + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", deletedDate=" + deletedDate + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", completed=" + completed + ", linkId=" + linkId + ", type=" + type + "]";
	}

	

	
	
	
}
