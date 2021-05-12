package com.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	@Query("select a from User a where username=:userId")
	public List<User> findByUserName(@Param("userId")String username);
	
	
	@Query("select u from User u where u.username=:username and u.password=:password ")
	User findByUserNameAndPassword(@Param("username")String username,@Param("password")String password);

}
