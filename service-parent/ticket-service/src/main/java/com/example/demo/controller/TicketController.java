package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TicketDto;
import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;

@RequestMapping("/ticket")
@RestController
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	
	  @GetMapping("/{id}")
	    public ResponseEntity<Optional<Ticket>> getById(@PathVariable Long id) {
		
	        return ResponseEntity.ok(ticketService.findById(id));
	    }

	    @PostMapping
	    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto) {
	    	return ResponseEntity.ok(ticketService.save(ticketDto));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<TicketDto> updateTicket(@PathVariable Long id,
	                                                  @RequestBody TicketDto ticketDto) {
	        return null;
	    }

	    @GetMapping
	    public ResponseEntity<Page<TicketDto>> getAll(Pageable pageable) {
	        return null;
	    }

}
