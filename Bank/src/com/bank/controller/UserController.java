package com.bank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bank.model.Login;
import com.bank.model.User;
import com.bank.service.UserService;

@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView showLogin() {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login", new Login());
	    return mav;
	  }
	
	 @RequestMapping(value = "/getString", method=RequestMethod.GET)
	    @ResponseBody
	    public String getString() {

	        return "This is a string for response";
	    }

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	  public ModelAndView login(@Valid @ModelAttribute("login") Login login,BindingResult result) {
	    if(result.hasErrors()) {
	    	 return new ModelAndView("login");
	    }
		ModelAndView mav = null;
		User user = userService.validateUser(login);
		    mav = new ModelAndView("welcome");
		    mav.addObject("firstname", user.getFirstname());
		    mav.addObject("user",user);
		    return mav;
	  }
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegister() {
	    ModelAndView mav = new ModelAndView("register");
	    mav.addObject("user", new User());
	    return mav;
	  }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	  public ModelAndView register(@ModelAttribute("user") User user) {
		user=userService.registerUser(user);
		ModelAndView mav = null;
		if(user!=null) {
			mav = new ModelAndView("welcome");
		    mav.addObject("firstname", user.getFirstname()+" "+user.getLastname());
		    mav.addObject("user",user);
		}else {
			mav = new ModelAndView("login");
		}
	    
	    return mav;
	  }
	
	
}
