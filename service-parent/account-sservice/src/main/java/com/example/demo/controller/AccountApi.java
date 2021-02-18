package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.Account;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountApi {
	@Autowired
	private AccountService accountService;


	@GetMapping
	public ResponseEntity<List<AccountDto>> getAll(Pageable page){
		
		return ResponseEntity.ok(accountService.getAll(page));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getById(@PathVariable("id") Long id) {
		
		return ResponseEntity.ok(accountService.get(id));

	}

	@PostMapping
	public ResponseEntity<AccountDto> save(@RequestBody AccountDto account) {
		
		return ResponseEntity.ok(accountService.save(account));

	}

	@PutMapping("/{id}")
	public ResponseEntity<AccountDto> update(@PathVariable Long id,@RequestBody AccountDto account) {
		
		return ResponseEntity.ok(accountService.update(id,account));

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id")Long id) {
		
		accountService.delete(id);

	}
	

}
