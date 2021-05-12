package com.bank.service.serviceimpl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.AccountDto;
import com.bank.dto.TransactionDto;
import com.bank.mapper.AccountMapper;
import com.bank.mapper.TransactionMapper;
import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.repository.AccountRepository;
import com.bank.repository.TransactionRepository;
import com.bank.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {
	
	
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountMapper accountMapper;
	
	@Autowired
	TransactionMapper transactionMapper;
	
@Transactional
public void deposit(TransactionDto transactionDto,Integer userId) {
		
		Account account=accountRepository.findByUserId(userId).get(0);
		AccountDto accountDto=accountMapper.entityToDto(account);
		accountDto.setBalance(accountDto.getBalance()+transactionDto.getAmount());
		Account account1=accountMapper.dtoToEntity(accountDto);
		accountRepository.save(account1);
		transactionDto.setAmount(transactionDto.getAmount());
		transactionDto.setUserId(userId);
		transactionDto.setAccountNumber(accountDto.getAccountNo());
		transactionDto.setDate(new Date());
		transactionDto.setTransactionType("Credit");
		transactionDto.setDescription("Self Deposit");
		Transaction transaction=transactionMapper.dtoToEntity(transactionDto);
		transactionRepository.save(transaction);
		
		
	}
	
@Transactional
public Boolean transfer(TransactionDto transactionDto,Integer userId) {
		
		Account from=accountRepository.findByUserId(userId).get(0);
		AccountDto accountDto=accountMapper.entityToDto(from);
		System.out.println("From Account Number:"+accountDto.getAccountNo());
		if(accountDto.getBalance()>transactionDto.getAmount()) {
			accountDto.setBalance(accountDto.getBalance()-transactionDto.getAmount());
			Account to=accountRepository.findByAccountNO(transactionDto.getAccountNumber()).get(0);
			AccountDto accountDto2=accountMapper.entityToDto(to);
			System.out.println("To Account Number:"+accountDto2.getAccountNo());
			accountDto2.setBalance(accountDto2.getBalance()+transactionDto.getAmount());
			Account fromAccount=accountMapper.dtoToEntity(accountDto);
			accountRepository.save(fromAccount);
			transactionDto.setAccountNumber(accountDto2.getAccountNo());
			transactionDto.setAmount(transactionDto.getAmount());
			transactionDto.setDate(new Date());
			transactionDto.setUserId(userId);
			transactionDto.setTransactionType("Debit");
			transactionDto.setDescription("Fund Transfer To");
			Transaction transaction=transactionMapper.dtoToEntity(transactionDto);
			transactionRepository.save(transaction);
			Account toAccount=accountMapper.dtoToEntity(accountDto2);
			accountRepository.save(toAccount);
			TransactionDto transactionDto1=new TransactionDto();
			transactionDto1.setAccountNumber(accountDto.getAccountNo());
			transactionDto1.setAmount(transactionDto.getAmount());
			transactionDto1.setDate(new Date());
			transactionDto1.setUserId(accountDto2.getUserId());
			transactionDto1.setTransactionType("Credit");
			transactionDto1.setDescription("Fund Transfer By");
			Transaction transaction1=transactionMapper.dtoToEntity(transactionDto1);
			transactionRepository.save(transaction1);
			return true;
		}
		else {
			return false;
		}
	}


}
