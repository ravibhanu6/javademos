package com.bank.service.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.AccountDto;
import com.bank.dto.UserDto;
import com.bank.mapper.AccountMapper;
import com.bank.mapper.UserMapper;
import com.bank.model.Account;
import com.bank.model.Login;
import com.bank.model.User;
import com.bank.repository.AccountRepository;
import com.bank.repository.UserRepository;
import com.bank.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	AccountMapper accountMapper;
	
	
	public User validateUser(Login login) {
		UserDto userDto=new UserDto();
		userDto.setUsername(login.getUsername());
		userDto.setPassword(login.getPassword());
		
//		User user=userRepository.findByUserName(login.getUsername()).get(0);
		User user1=userRepository.findByUserNameAndPassword(userDto.getUsername(), userDto.getPassword());
		
		
		if(user1==null) {
			return null;
		}
		UserDto userDto1=userMapper.entitytoDto(user1);
		if(user1!=null && userDto.getPassword().equals(login.getPassword())) {
			Account account=accountRepository.findByUserId(user1.getId()).get(0);
			user1.setAccount(account);
			userDto1.setAccount(account);
			return user1;
		}
			
		return null;
		
		
	}
	
	public User registerUser(User user) {
		userRepository.save(user);
		
		AccountDto accountDto=new AccountDto();
		accountDto.setAccountNo(10000+user.getId());
		accountDto.setBalance(1000.00);
		accountDto.setUserId(user.getId());
		Account account= accountMapper.dtoToEntity(accountDto);
		accountRepository.save(account);
		user.setAccount(account);
		return user;
	}
	
	public User getUserDetails(Integer userId) {
		
		User user=null;
		Optional<User> optional=userRepository.findById(userId);
		if(optional.isPresent()) {
			user=optional.get();
			Account account=accountRepository.findByUserId(user.getId()).get(0);
			user.setAccount(account);
			
		}
		return user;
	}

}
