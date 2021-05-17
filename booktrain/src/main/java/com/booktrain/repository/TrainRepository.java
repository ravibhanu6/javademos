package com.booktrain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booktrain.model.Train;


@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {

	 @Query(value="select train_id,count(*) count from train_station where station_id in "
	 		+ "(select station_id from station where station_name in (:from,:to)) group by train_id having count=2", nativeQuery = true)
	 public List<Integer> findTrainIdByStationId(@Param("from") String from, @Param("to")String to);
	 
	 @Query("select t from Train t where trainId in (:trainIds)")
	 public List<Train> finTrainsBySpecificIds(@Param("trainIds")List<Integer> trainIds);
}
