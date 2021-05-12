package com.bank.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bank.dto.TransactionDto;
import com.bank.model.Transaction;


/**
 * @author ravi
 *
 */
@Component
public class TransactionMapper {
	
	public Transaction dtoToEntity(TransactionDto dto) {
		Transaction transaction =new Transaction();
		transaction.setId(dto.getId());
		transaction.setAccountNumber(dto.getAccountNumber());
		transaction.setAmount(dto.getAmount());
		transaction.setUserId(dto.getUserId());
		transaction.setTransactionType(dto.getTransactionType());
		transaction.setDate(dto.getDate());
		transaction.setDescription(dto.getDescription());
		return transaction;
	}
	
	public List<TransactionDto> entityToDto(List<Transaction> transactions){
		List<TransactionDto> list = new ArrayList<TransactionDto>();
		
		for(Transaction transaction: transactions) {
			TransactionDto dto=new TransactionDto();
			dto.setId(transaction.getId());
			dto.setAccountNumber(transaction.getAccountNumber());
			dto.setAmount(transaction.getAmount());
			dto.setUserId(transaction.getUserId());
			dto.setTransactionType(transaction.getTransactionType());
			dto.setDate(transaction.getDate());
			dto.setDescription(transaction.getDescription());
			list.add(dto);
		}
		return list;
	}

}
