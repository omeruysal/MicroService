package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TicketNotification;
import com.example.demo.model.Ticket;

@Service
@EnableBinding(Source.class)
public class TicketNotificationService {
	
	@Autowired
	Source source;
	
	
	public void sendToQueue(Ticket ticket) {
		TicketNotification ticketNotification = new TicketNotification();
		 ticketNotification.setAccountId(ticket.getAssignee());
	     ticketNotification.setTicketId(ticket.getId());
	     ticketNotification.setTicketDescription(ticket.getDescription());
	     
	     source.output().send(MessageBuilder.withPayload(ticketNotification).build());
	     
	 
	}

}
