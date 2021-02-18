package com.example.demo.client.contract;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

	private long id;
	private String username;
	private String name;
	private String surname;
	private String email;
	
}