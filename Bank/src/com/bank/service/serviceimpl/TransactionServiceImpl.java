package com.bank.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.TransactionDto;
import com.bank.mapper.TransactionMapper;
import com.bank.model.Transaction;
import com.bank.repository.TransactionRepository;
import com.bank.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	TransactionMapper transactionMapper;

	@Override
	public List<TransactionDto> getTransactionDetails(Integer userId) {
		List<Transaction> transactions=transactionRepository.findByUserId(userId);
		System.out.println(transactions);
		List<TransactionDto> list=transactionMapper.entityToDto(transactions);
		System.out.println(list);
		return list;
	}
}
