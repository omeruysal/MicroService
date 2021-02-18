package com.example.demo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
	
	  	private Long id;

	    private String description;

	    private String notes;

	    private Long assignee;

	    private Date ticketDate;

	    private String priorityType;

	    private String ticketStatus;

}
