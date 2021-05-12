package com.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.dto.TransactionDto;

@Service
public interface TransactionService {
	public List<TransactionDto> getTransactionDetails(Integer userId);
}
