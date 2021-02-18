package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(of = {"id"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    
	    @Column(length = 600)
	    private String description;

	   
	    @Column(length = 1000)
	    private String notes;

	    
	    private Long assignee;

	   
	    private Date ticketDate;

	    
	    @Enumerated(EnumType.ORDINAL)
	    private PriorityType priorityType;

	    
	    @Enumerated(EnumType.ORDINAL)
	    private TicketStatus ticketStatus;

}
