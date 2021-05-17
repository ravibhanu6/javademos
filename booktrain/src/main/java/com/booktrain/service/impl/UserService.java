package com.booktrain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booktrain.dto.UserDTO;
import com.booktrain.model.Ticket;
import com.booktrain.model.User;
import com.booktrain.repository.TicketRepository;
import com.booktrain.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Ticket> getHisotry(Integer userId) {
		
		 List<Ticket> tickets=ticketRepository.getTicketHisotryByUserId(userId);
		 return tickets;
	}
	
	public Integer registerUser(UserDTO userDTO) {
		
		User user=new User();
		user.setAge(userDTO.getAge());
		user.setEmailId(userDTO.getEmailId());
		user.setPassword(userDTO.getPassword());
		user.setPhoneNo(userDTO.getPhoneNo());
		user.setUserName(userDTO.getUserName());
		user.setRole("user");
		userRepository.save(user);
		
		
		return user.getUserId();
		
	}
}
