package com.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer>{
	@Query("select t from Transaction t where userId=:userId")
	public List<Transaction> findByUserId(@Param("userId")Integer userId);
}
