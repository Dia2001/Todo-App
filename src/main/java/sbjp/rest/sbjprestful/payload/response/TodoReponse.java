package sbjp.rest.sbjprestful.payload.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
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
}
