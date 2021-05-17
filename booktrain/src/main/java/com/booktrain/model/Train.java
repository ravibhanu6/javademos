package com.booktrain.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Train {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer trainId;

    private Integer trainNumber;
    
	private String trainName;
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="TRAIN_STATION", joinColumns={@JoinColumn(name="TRAIN_ID", referencedColumnName="trainId")}
    , inverseJoinColumns={@JoinColumn(name="STATION_ID", referencedColumnName="stationId")})
	private List<Station> stations;
	
	private String duration;
	
	private Integer availableSeats;
	
	@ElementCollection
	@CollectionTable(name="TrainAvailability", joinColumns=@JoinColumn(name="trainId"))
	@Column(name="availableOn")
	private Set<String> availableOn=new HashSet<>();
	
	

	public Set<String> getAvailableDays() {
		return availableOn;
	}

	public void setAvailableDays(Set<String> availableDays) {
		this.availableOn = availableDays;
	}
	
	public void addAvailableOn(String availbleOn) {
		this.availableOn.add(availbleOn);
	}

	public Integer getTrainId() {
		return trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public Integer getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(Integer trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	} 
	
	@Override
	public String toString() {
		
		return trainName+" "+getAvailableDays();
	}
	
	

}
