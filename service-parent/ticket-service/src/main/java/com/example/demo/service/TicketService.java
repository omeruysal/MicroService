package com.example.demo.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.TicketDto;
import com.example.demo.model.PriorityType;
import com.example.demo.model.Ticket;
import com.example.demo.model.TicketStatus;
import com.example.demo.model.elastic.TicketElasticModel;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.elastic.TicketElasticRepository;

@Service
@EnableFeignClients
public class TicketService {
	
	@Autowired
	TicketElasticRepository ticketElasticRepository;
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	ModelMapper modelMMapper;
	
	@Autowired
	AccountServiceClient accountServiceClient;
	
	@Autowired
	TicketNotificationService ticketNotificationService;
	
	
	
	    @Transactional
	    public TicketDto save(TicketDto ticketDto) {
	        // Ticket Entity
	        if (ticketDto.getDescription() == null)
	            throw new IllegalArgumentException("Description bos olamaz");

	        Ticket ticket = new Ticket();
	        System.out.println(ticketDto.getAssignee());
	       ResponseEntity<AccountDto> accountDtoResponseEntity = accountServiceClient.getById(ticketDto.getAssignee());//id ye sahip olan kisiyi getiririz
	       
	      System.out.println("cikti");
	        ticket.setDescription(ticketDto.getDescription());
	        ticket.setNotes(ticketDto.getNotes());
	        ticket.setTicketDate(ticketDto.getTicketDate());
	        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
	        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
	        ticket.setAssignee(accountDtoResponseEntity.getBody().getId());

	        // mysql kaydet
	        ticket = ticketRepository.save(ticket);

    		String elasticAssigneName = accountDtoResponseEntity.getBody().getName()+" "+accountDtoResponseEntity.getBody().getSurname();
    		System.out.println("burada");
    		System.out.println(elasticAssigneName);
    		
	        // TicketModel nesnesi yarat
	        TicketElasticModel model = new TicketElasticModel(ticket.getId().toString(),
	        		ticket.getDescription(),
	        		ticket.getNotes(),
	        		elasticAssigneName,
	        		ticket.getTicketDate(),
	        		ticket.getPriorityType().getLabel(),
	        		ticket.getTicketStatus().getLabel());
	             
	        // elastic kaydet
	        ticketElasticRepository.save(model);

	        // olusan nesneyi döndür
	        ticketDto.setId(ticket.getId());

	        // Kuyruga notification yaz
	       ticketNotificationService.sendToQueue(ticket);
	        return ticketDto;
	    }
	    
	    public Optional<Ticket> findById(Long id){
	    	
	    	return ticketRepository.findById(id);
	    }

}
