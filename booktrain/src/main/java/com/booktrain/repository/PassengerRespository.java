package com.booktrain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booktrain.model.Passenger;

@Repository
public interface PassengerRespository extends JpaRepository<Passenger,Integer> {

}
