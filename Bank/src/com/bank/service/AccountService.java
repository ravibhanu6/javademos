package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.dto.TransactionDto;

@Service
public interface AccountService {
	public void deposit(TransactionDto transactionDto,Integer userId);
	public Boolean transfer(TransactionDto transactionDto,Integer userId);

}
