package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.AccountDto;



@FeignClient("account-service")
public interface AccountServiceClient {

	@GetMapping("account/{id}")
	 ResponseEntity<AccountDto> getById(@PathVariable("id") Long id);
}
