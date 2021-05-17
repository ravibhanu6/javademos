package com.booktrain.service;

import java.util.List;

import com.booktrain.dto.UserDTO;
import com.booktrain.model.Ticket;

public interface UserService {
	
	
	public List<Ticket> getHisotry(Integer userId);
	
	public Integer registerUser(UserDTO userDTO);

}
