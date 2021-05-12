package com.bank.controller;

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
import com.bank.model.Transaction;
import com.bank.model.User;
import com.bank.service.AccountService;
import com.bank.service.UserService;

@Controller
public class AccountController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	UserMapper userMapper;
	
	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
	  public ModelAndView showDeposit(@RequestParam("userId") Integer userId) {
	    ModelAndView mav = new ModelAndView("deposit");
	    User user=userService.getUserDetails(userId);
	    UserDto userDto=userMapper.entitytoDto(user);
	    mav.addObject("firstname", userDto.getFirstname()+" "+userDto.getLastname());
	    mav.addObject("user",user);
	    mav.addObject("transaction",new Transaction());
	    return mav;
	  }
	
	
	
	  @RequestMapping(value = "/deposit", method = RequestMethod.POST)
	  public ModelAndView deposit(@ModelAttribute("transaction") TransactionDto transactionDto) {
		  
		
		accountService.deposit(transactionDto,transactionDto.getUserId());
		  
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
	  
	  
	  @RequestMapping(value = "/transfer", method = RequestMethod.GET)
	  public ModelAndView showTransfer(@RequestParam("userId") Integer userId) {
	    ModelAndView mav = new ModelAndView("transfer");
	    User user=userService.getUserDetails(userId);
	    UserDto userDto=userMapper.entitytoDto(user);
	    mav.addObject("firstname", userDto.getFirstname()+" "+userDto.getLastname());
	    mav.addObject("user",user);
	    mav.addObject("transaction",new Transaction());
	    return mav;
	  }
	  
}
