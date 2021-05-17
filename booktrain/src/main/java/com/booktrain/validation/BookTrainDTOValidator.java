package com.booktrain.validation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.booktrain.dto.BookTrainDTO;
import com.booktrain.dto.PassengerDTO;



@Component
public class BookTrainDTOValidator implements Validator{
	
	
	SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

	@Override
	public boolean supports(Class<?> clazz) {
		
		
		boolean value=BookTrainDTO.class.isAssignableFrom(clazz);
		System.out.println("BookTrainDTO ....supports"+value);
		
		//return BookTrainDTO.class.isAssignableFrom(clazz) || SearchDTOValidator.class.isAssignableFrom(clazz);
		return true;
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		if(object instanceof BookTrainDTO) {
		   
			BookTrainDTO bookTrainDTO=(BookTrainDTO)object;
			
			/*if(bookTrainDTO.getTrainId()==null) {
				errors.reject("trainId","Train Id Should Not Be Null");
			}
			
			if(bookTrainDTO.getUserId()==null) {
				errors.reject("userId","User Id Should Not Be Null");
			}*/
			
			
			if(bookTrainDTO.getNoOfSeats()==null) {
				errors.reject("noOfSeats","noOfSeats Should Not Be Null");
			}else if(bookTrainDTO.getNoOfSeats()==0) {
				errors.reject("noOfSeats","noOfSeats Should Greater Than 0");
			}else if(bookTrainDTO.getNoOfSeats()>5) {
				errors.reject("noOfSeats","noOfSeats Should Not Be Greater Than 5");
			}else if(bookTrainDTO.getNoOfSeats()!=bookTrainDTO.getPassengers().size()){
				errors.reject("noOfSeats","noOfSeats Should Match With Passengers List");
			}
			
			
			if(bookTrainDTO.getDateOfJourney()==null) {
				errors.reject("dateOfJourney","dateOfJourney Should Not Be Null");
			}else{
				try {
					Date date=dateFormatter.parse(bookTrainDTO.getDateOfJourney());	
					System.out.println("DateOfJourney:"+date);
					Date currentDate=dateFormatter.parse(dateFormatter.format(new Date()));
					System.out.println("CurrentDate:"+currentDate);
					if(date.before(currentDate)) {
						errors.reject("dateOfJourney","dateOfJourney Should Not Be Before Current Date");		
					}
				}catch(Exception e) {
					errors.reject("dateOfJourney","dateOfJourney Should Be In Format Of dd-MM-yyyy");
				}
			}
			
			if(bookTrainDTO.getSource()==null) {
				errors.reject("source","source Should Not Be Null");
			}else if(bookTrainDTO.getSource().equals("")) {
				errors.reject("source","source Should Not Be Empty");
			}
			
			if(bookTrainDTO.getDestination()==null) {
				errors.reject("destination","destination Should Not Be Null");
			}else if(bookTrainDTO.getDestination().equals("")) {
				errors.reject("destination","destination Should Not Be Empty");
			}
			
			List<PassengerDTO> passengers=bookTrainDTO.getPassengers();
			
			if(passengers==null) {
				errors.reject("passengers","passengers Should Not Be Null");	
			}else if(passengers.size()!=bookTrainDTO.getNoOfSeats()){
				errors.reject("passengers","passengers Should Be Equal To No Of Passengers");
			}else {
				for(int i=0;i<passengers.size();i++) {
					PassengerDTO passenger=passengers.get(i);
					if(passenger.getPassengerName()==null) {
						errors.reject("passengers.passengerName."+i,"PassengerName Should Not Be Null");	
					}else if(passenger.getPassengerName().equals("")) {
						errors.reject("passengers.passengerName."+i,"PassengerName Should Not Be Empty");
					}
					
					if(passenger.getAge()==null) {
						errors.reject("passengers.age"+i,"Age Should Not Be Null");	
					}else if(passenger.getAge()==0) {
						errors.reject("passengers.age"+i,"Age Should Not Be Greater Than Zero");
					}
				}
			}
		}
		
	}

}
