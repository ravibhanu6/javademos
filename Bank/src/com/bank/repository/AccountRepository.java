package com.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	@Query("select a from Account a where userId=:userId")
	public List<Account> findByUserId(@Param("userId")Integer userId);
	
	@Query("select a from Account a where accountNo=:accountNo")
	public List<Account> findByAccountNO(@Param("accountNo")Integer accountNo);

}
