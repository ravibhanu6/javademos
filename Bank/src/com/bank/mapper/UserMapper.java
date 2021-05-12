package com.bank.mapper;

import org.springframework.stereotype.Component;

import com.bank.dto.UserDto;
import com.bank.model.User;

/**
 * @author ravi
 *
 */

@Component
public class UserMapper {
	
	public User dtoToEntity(UserDto dto) {
		User user=new User();
		user.setId(dto.getId());
		user.setFirstname(dto.getFirstname());
		user.setLastname(dto.getLastname());
		user.setUsername(dto.getUsername());
		user.setAccount(dto.getAccount());
		user.setPassword(dto.getPassword());
		user.setPhoneNo(dto.getPhoneNo());
		user.setEmail(dto.getEmail());
		return user;
	}
	
	public UserDto entitytoDto(User user) {
			UserDto dto=new UserDto();
			dto.setId(user.getId());
			dto.setFirstname(user.getFirstname());
			dto.setLastname(user.getLastname());
			dto.setUsername(user.getUsername());
			dto.setAccount(user.getAccount());
			dto.setPassword(user.getPassword());
			dto.setPhoneNo(user.getPhoneNo());
			dto.setEmail(user.getEmail());
			return dto;
	}

}
