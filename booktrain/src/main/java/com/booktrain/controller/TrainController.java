package com.booktrain.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.booktrain.dto.BookTrainDTO;
import com.booktrain.dto.SearchDTO;
import com.booktrain.model.Ticket;
import com.booktrain.model.Train;
import com.booktrain.service.TrainService;
import com.booktrain.validation.BookTrainDTOValidator;
import com.booktrain.validation.SearchDTOValidator;

@RestController
public class TrainController {

	private Logger logger=LoggerFactory.getLogger(TrainController.class);
	
	@Autowired
	private TrainService trainService;
	
    @Autowired
	private BookTrainDTOValidator bookTrainDTOValidation;
    
    @Autowired
    private SearchDTOValidator searchDTOValidator;
    
    
    
    @InitBinder
    public void initBookBinder(WebDataBinder binder) {
     binder.addValidators(bookTrainDTOValidation);
    }
    
    @InitBinder
    public void initSearchBinder(WebDataBinder binder) {
     binder.addValidators(searchDTOValidator);
    }
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";	
	}


	@GetMapping("/load_data")
	public String loadData() {

		
		trainService.loadData();
		return "Datat Loaded SUccessfully";
	}
	
	
	@PostMapping("/search")
	public ResponseEntity<List<?>> search(@RequestBody @Valid SearchDTO searchDTO) throws Exception {
		
		logger.info("Before Search");
		List<Train> trains=trainService.searchTrain(searchDTO);
		logger.info("After Search Search");
		return new ResponseEntity<>(trains,HttpStatus.OK);
	}
	
	
	@PostMapping("/book")
	public ResponseEntity<Ticket> book(@RequestBody @Valid BookTrainDTO bookTrainDto,HttpServletRequest httpServletRequest) throws Exception{
		
		logger.info("Before Booking");
		
		Integer userId=(Integer)httpServletRequest.getAttribute("userId");
		bookTrainDto.setUserId(userId);
		
		Ticket ticket=trainService.bookTrarin(bookTrainDto);
		
		logger.info("After Booking" ,ticket);
		return new ResponseEntity<>(ticket,HttpStatus.OK);
	}


}
