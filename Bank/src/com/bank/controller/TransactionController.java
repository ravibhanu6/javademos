package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bank.dto.TransactionDto;
import com.bank.dto.UserDto;
import com.bank.mapper.UserMapper;
import com.bank.model.User;
import com.bank.service.AccountService;
import com.bank.service.TransactionService;
import com.bank.service.UserService;

@Controller
public class TransactionController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	UserMapper userMapper;
	
	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	  public ModelAndView transfer(@ModelAttribute("transaction") TransactionDto transactionDto) {
		  
		System.out.println("Transfering the amount");
		Boolean b=accountService.transfer(transactionDto,transactionDto.getUserId());
		if(b!=true) {
			ModelAndView mav = null;
			mav = new ModelAndView("transfer");
		    mav.addObject("error_msg", "invalid amount");
//		    mav.addObject("user",user);
		}
		User user=userService.getUserDetails(transactionDto.getUserId());
		UserDto userDto=userMapper.entitytoDto(user);
		ModelAndView mav = null;
		if(userDto!=null) {
			mav = new ModelAndView("welcome");
		    mav.addObject("firstname", userDto.getFirstname()+" "+userDto.getLastname());
		    mav.addObject("user",user);
		}else {
			mav = new ModelAndView("login");
		}
	    
	    return mav; 
	  }
	
	
	
	  @RequestMapping(value = "/history", method = RequestMethod.GET)
	  public ModelAndView showHistory(@RequestParam("userId") Integer userId) {
		  ModelAndView mav = new ModelAndView("history");
		  User user=userService.getUserDetails(userId);
		  UserDto userDto=userMapper.entitytoDto(user);
		  List<TransactionDto> list= transactionService.getTransactionDetails(userId);
		  mav.addObject("firstname",  userDto.getFirstname()+" "+userDto.getLastname());
		  mav.addObject("message", "Your transactions ");
		  mav.addObject("transactions",list );
		  return mav;
	  }

}
