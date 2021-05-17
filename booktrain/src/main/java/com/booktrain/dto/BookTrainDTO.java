package com.booktrain.dto;


import java.util.List;



public class BookTrainDTO {
	
	
	
	private Integer trainId;
	
	private Integer userId;
	
	private Integer noOfSeats;
	
	private List<PassengerDTO> passengers;
	
	
	private String dateOfJourney;
	
	private String source;
	
	private String destination;
	

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

    

	public String getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public Integer getTrainId() {
		return trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public List<PassengerDTO> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<PassengerDTO> passengers) {
		this.passengers = passengers;
	}
	
	

}
