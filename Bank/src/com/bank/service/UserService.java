package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.model.Login;
import com.bank.model.User;

@Service
public interface UserService {
	public User validateUser(Login login);
	public User getUserDetails(Integer userId);
	public User registerUser(User user);
}
