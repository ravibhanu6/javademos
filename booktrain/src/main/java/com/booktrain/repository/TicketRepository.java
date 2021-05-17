package com.booktrain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.booktrain.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
	
	
	@Query("select t from Ticket t where userId=:userId")
	public List<Ticket> getTicketHisotryByUserId(@Param("userId")Integer userId);

}
