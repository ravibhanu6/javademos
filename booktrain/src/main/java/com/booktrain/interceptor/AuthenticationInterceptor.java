package com.booktrain.interceptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.booktrain.model.User;
import com.booktrain.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String username=request.getHeader("username");
		String password=request.getHeader("password");
		System.out.println("preHanlde......."+request.getRequestURI());
		if(username!=null && password!=null) {
			List<User> list=userRepository.findUserByUsernameAndPassword(username, password);
			if(list.size()==0) {
				
				 ObjectMapper mapper = new ObjectMapper();
				  Map<String,String> map=new HashMap<>();
				  map.put("invalid", "credentials are invalid");
				  response.setContentType("application/json");
				  response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				  response.getWriter().write(mapper.writeValueAsString(map));
				return false;
			}else {
				request.setAttribute("userId",list.get(0).getUserId());
			}
		}else {
			ObjectMapper mapper = new ObjectMapper();
			Map<String,String> map=new HashMap<>();
			map.put("invalid", "please provide credentials");
			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write(mapper.writeValueAsString(map));
			return false;
		}
		return true;
		
	}

}
