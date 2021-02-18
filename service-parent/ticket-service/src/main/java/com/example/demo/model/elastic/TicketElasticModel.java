package com.example.demo.model.elastic;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of= {"id"})
@Document(indexName= "ticket")
@AllArgsConstructor
@NoArgsConstructor
public class TicketElasticModel {
	
	@Id
    private String id;

    
    private String description;

   
    private String notes;

    
    private String assignee;

   
    private Date ticketDate;

    
    
    private String priorityType;

    
    
    private String ticketStatus;

}
