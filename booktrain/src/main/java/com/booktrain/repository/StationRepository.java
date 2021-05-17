package com.booktrain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booktrain.model.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {

}
