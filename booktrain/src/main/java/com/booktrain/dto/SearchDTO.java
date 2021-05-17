package com.booktrain.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class SearchDTO {
	
	
	@NotBlank(message = "Please Provide From")
	private String from;
	
	
	@NotBlank(message = "Please Provide To")
	private String to;
	
	
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please Provide date")
	private String date;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	

}
