package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

@Service
@EnableFeignClients
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public AccountDto get(Long id) {
	Account account =	accountRepository.findById(id).orElseThrow(()-> new NullPointerException());

		return modelMapper.map(account, AccountDto.class);
	}

	public AccountDto save(AccountDto accountDto) {
		Account account = modelMapper.map(accountDto, Account.class);
		account = accountRepository.save(account);
		accountDto.setId(account.getId());
		
		return accountDto;
	}

	public AccountDto update(Long id,AccountDto accountDto) {
		 Assert.isNull(id, "Id cannot be null");
	        Optional<Account> account = accountRepository.findById(id);
	        
	        Account accountToUpdate = account.map(it -> {
	            it.setName(accountDto.getName());
	            it.setSurname(accountDto.getSurname());
	            return it;
	        }).orElseThrow(IllegalArgumentException::new);
	        
	        return modelMapper.map(accountRepository.save(accountToUpdate), AccountDto.class);
	}

	public void delete(Long id) {
		Account account =	accountRepository.findById(id).orElseThrow(()-> new NullPointerException());
		accountRepository.delete(account);

	}

	public List<AccountDto> getAll(Pageable page) {

		Page<Account> accounts = accountRepository.findAll(page);

		return null;
	}
	
	

}
