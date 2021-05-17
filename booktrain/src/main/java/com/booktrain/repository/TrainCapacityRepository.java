package com.booktrain.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booktrain.model.TrainCapacity;


@Repository
public interface TrainCapacityRepository extends JpaRepository<TrainCapacity, Integer>{

	@Query("select t from TrainCapacity t where trainId=:trainId and date=:journeyDate")
	public List<TrainCapacity> checkTrainSeatsAvailability(@Param("trainId") Integer trainId,@Param("journeyDate")Date journeyDate);
}
