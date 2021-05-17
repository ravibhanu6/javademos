package com.booktrain.validation;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.booktrain.dto.BookTrainDTO;
import com.booktrain.dto.SearchDTO;

@Component
public class SearchDTOValidator implements Validator{
	
	SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

	@Override
	public boolean supports(Class<?> clazz) {
		
		boolean value=SearchDTO.class.isAssignableFrom(clazz);
		System.out.println("Search DTO ....supports"+value);
		
		//return SearchDTOValidator.class.isAssignableFrom(clazz) || BookTrainDTO.class.isAssignableFrom(clazz) ;
		return true;
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		
		if(object instanceof SearchDTO) {
		  
			SearchDTO searchDTO=(SearchDTO)object;
			
			
			if(searchDTO.getFrom()==null) {
				errors.reject("from","from Should Not Be Null");
			}else if(searchDTO.getFrom().equals("")) {
				errors.reject("from","from Should Not Be Empty");
			}
			
			if(searchDTO.getTo()==null) {
				errors.reject("to","to Should Not Be Null");
			}else if(searchDTO.getTo().equals("")) {
				errors.reject("to","to Should Not Be Empty");
			}
			
			if(searchDTO.getDate()==null) {
				errors.reject("date","date Should Not Be Null");
			}else if(searchDTO.getTo().equals("")) {
				errors.reject("date","date Should Not Be Empty");
			}else{
				try {
					Date date=dateFormatter.parse(searchDTO.getDate());	
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
			
			
		
			
		}
		
	}

}
