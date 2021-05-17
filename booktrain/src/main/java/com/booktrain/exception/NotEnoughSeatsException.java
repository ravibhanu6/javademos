package com.booktrain.exception;

public class NotEnoughSeatsException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	
	private String date;
	
	private Integer trainId;
	
	public NotEnoughSeatsException(String message,String date,Integer trainId) {
		
		this.message=message;
		this.date=date;
		this.trainId=trainId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getTrainId() {
		return trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}
	
	

}
