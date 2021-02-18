package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.client.contract.AccountDto;

@FeignClient("account-sservice")
public interface AccountServiceClient {
	
	@RequestMapping("/api/1.0/accounts/{id}")
	 ResponseEntity<AccountDto> getById(@PathVariable("id") Long id);

}
