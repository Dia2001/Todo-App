package sbjp.rest.sbjprestful.payload.request;

import java.util.Date;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class TodoRequest {

	private int id;
	
	private String title;
	
	private String description;

	private Date createdDate;

	private Date updatedDate;

	private Date deletedDate;
	
	private Date startDate;
	
	private Date endDate;

	private Boolean completed;
	
	private int link_id;
	
	private int type;
	
	
}
