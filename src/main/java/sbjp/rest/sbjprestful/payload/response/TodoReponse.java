package sbjp.rest.sbjprestful.payload.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TodoReponse {
	
	private int id;

	private String title;

	private String description;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createdDate;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date updatedDate;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date deletedDate;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startDate;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endDate;

	private Boolean completed;

	private int link_id;

	private int type;

	public TodoReponse() {
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

	public int getLink_id() {
		return link_id;
	}

	public void setLink_id(int link_id) {
		this.link_id = link_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TodoRequest [id=" + id + ", title=" + title + ", description=" + description + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", deletedDate=" + deletedDate + ", startDate="
				+ startDate + ", endDate=" + endDate + ", completed=" + completed + ", link_id=" + link_id + ", type="
				+ type + "]";
	}
}
