package com.booktrain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.booktrain.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	@Query("select u from User u where userName=:username and password=:password")
	public List<User> findUserByUsernameAndPassword(@Param("username")String username,@Param("password")String password);

}
