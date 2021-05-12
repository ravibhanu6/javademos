package com.bank.mapper;

import org.springframework.stereotype.Component;

import com.bank.dto.AccountDto;
import com.bank.model.Account;

/**
 * @author ravi
 *
 */

@Component
public class AccountMapper {
	
	public Account dtoToEntity(AccountDto dto) {
		Account account=new Account();
		account.setAccountNo(dto.getAccountNo());
		account.setId(dto.getId());
		account.setBalance(dto.getBalance());
		account.setUserId(dto.getUserId());
		return account;
	}
	
	public AccountDto entityToDto(Account account) {
		AccountDto dto =new AccountDto();
		dto.setId(account.getId());
		dto.setAccountNo(account.getAccountNo());
		dto.setBalance(account.getBalance());
		dto.setUserId(account.getUserId());
		return dto;
	}

}
