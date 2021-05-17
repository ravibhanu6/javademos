package com.booktrain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Station {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer stationId;
	
	private String stationName;
	
	private String stationCode;
	
	public Station() {
		
	}
	
	public Station(String stationName,String stationCode) {
		
		this.stationName=stationName;
		this.stationCode=stationCode;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	} 
	
	

}
