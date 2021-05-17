package com.booktrain.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booktrain.dto.BookTrainDTO;
import com.booktrain.dto.PassengerDTO;
import com.booktrain.dto.SearchDTO;
import com.booktrain.exception.NotEnoughSeatsException;
import com.booktrain.model.DayEnum;
import com.booktrain.model.Passenger;
import com.booktrain.model.Station;
import com.booktrain.model.Ticket;
import com.booktrain.model.Train;
import com.booktrain.model.TrainCapacity;
import com.booktrain.repository.PassengerRespository;
import com.booktrain.repository.StationRepository;
import com.booktrain.repository.TicketRepository;
import com.booktrain.repository.TrainCapacityRepository;
import com.booktrain.repository.TrainRepository;
import com.booktrain.service.TrainService;
import com.booktrain.util.DateUtils;

@Service
public class TrainServiceImpl implements TrainService{
	
	private Logger logger = LoggerFactory.getLogger(TrainServiceImpl.class);
	
	
	@Autowired
	private TrainRepository trainRepository;
	
	@Autowired
	private StationRepository stationRepository;
	
	@Autowired
	private PassengerRespository passengerRespository;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private TrainCapacityRepository trainCapacityRepository;
	
	SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
	
	public void loadData() {
		
		
		Station s1=new Station("Secunderabad JN","SCJ");
		Station s2=new Station("Kazipet","KZP");
		Station s3=new Station("Warangal","WGL");
		Station s4=new Station("Khammam","KHM");
		Station s5=new Station("Vijayawada","VJW");
		Station s6=new Station("Rajhamundry","RJY");
		Station s7=new Station("Kakinada","KAK");
		Station s8=new Station("Tuni","TUN");
		Station s9=new Station("ANNAVARAM","ANV");
		Station s10=new Station("Vizag","VIZ");
		Station s11=new Station("Kachiguda","KCG");
		Station s12=new Station("Nampally","NMP");
		Station s13=new Station("Guntur","GUN");
		Station s14=new Station("Bheemavaram","BHM");
		Station s15=new Station("Kovvuru","KOV");
		
		stationRepository.save(s1);
		stationRepository.save(s1);
		stationRepository.save(s2);
		stationRepository.save(s3);
		stationRepository.save(s4);
		stationRepository.save(s5);
		stationRepository.save(s6);
		stationRepository.save(s7);
		stationRepository.save(s8);
		stationRepository.save(s9);
		stationRepository.save(s10);
		stationRepository.save(s11);
		stationRepository.save(s12);
		stationRepository.save(s13);
		stationRepository.save(s14);
		stationRepository.save(s15);
        
		Train train1 =new Train();

		train1.setTrainNumber(12345);
		train1.setTrainName("Gouthami Express");
		train1.setDuration("10 Hours");
		train1.setAvailableSeats(10);
		List<Station> list=new ArrayList<Station>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		list.add(s6);
		list.add(s7);
	    train1.setStations(list);
	    
	
	    train1.addAvailableOn(DayEnum.MON.toString());
	    train1.addAvailableOn(DayEnum.FRI.toString());
	    train1.addAvailableOn(DayEnum.SAT.toString());
	    
		
	    trainRepository.save(train1);

		Train train2 =new Train();

		train2.setTrainNumber(22345);
		train2.setTrainName("Godavari Express");
		train2.setDuration("12 Hours");
		train2.setAvailableSeats(20);
		List<Station> list2=new ArrayList<Station>();
		list2.add(s12);
		list2.add(s2);
		list2.add(s3);
		list2.add(s4);
		list2.add(s5);
		list2.add(s6);
		list2.add(s8);
		list2.add(s9);
		list2.add(s10);
		
		train2.setStations(list2);
		
	    train2.addAvailableOn(DayEnum.TUE.toString());
	    train2.addAvailableOn(DayEnum.THU.toString());
		
		trainRepository.save(train2);
		
		Train train3 =new Train();

		train3.setTrainNumber(33345);
		train3.setTrainName("Shatavahana Express");
		train3.setDuration("8 Hours");
		train3.setAvailableSeats(15);
		List<Station> list3=new ArrayList<Station>();
		list3.add(s5);
		list3.add(s13);
		list3.add(s14);
		list3.add(s15);
		list3.add(s6);
		
		train3.setStations(list3);
		
		train3.addAvailableOn(DayEnum.ALL.toString());
		
		trainRepository.save(train3);
	}
	
	
	public List<Train> searchTrain(SearchDTO searchDto) throws Exception{
		Date searchDate=dateFormatter.parse(searchDto.getDate());
		logger.info("Search Date "+searchDate);
		String day=DateUtils.getDayFromDate(searchDate);
		logger.info("Search Day "+day);
		List<Integer> trainIds=trainRepository.findTrainIdByStationId(searchDto.getFrom(),searchDto.getTo());
		List<Train> trains=trainRepository.finTrainsBySpecificIds(trainIds);
		logger.info("Before .... "+trains);
		Iterator<Train> trainIterator= trains.iterator();
		while(trainIterator.hasNext()) {
			Train train=trainIterator.next();
			if(!train.getAvailableDays().contains(DayEnum.ALL.toString()) && !train.getAvailableDays().contains(day)) {
				trainIterator.remove();
			}
		}
		logger.info("After .... "+trains);
		return trains;
	}
	
	@Transactional
	public Ticket bookTrarin(BookTrainDTO bookTrainDTO) throws Exception{
		
		List<TrainCapacity> trainCapacitiess= trainCapacityRepository.checkTrainSeatsAvailability(bookTrainDTO.getTrainId(),dateFormatter.parse(bookTrainDTO.getDateOfJourney()));
		if(trainCapacitiess.size()!=0 && trainCapacitiess.get(0).getAvailableSeats()<bookTrainDTO.getNoOfSeats()) {
			logger.error("Not Enough Seats Available");
			throw new NotEnoughSeatsException("Not Enough Seats", dateFormatter.parse(bookTrainDTO.getDateOfJourney()).toString(),bookTrainDTO.getTrainId());
		}else {
			
			Train train=trainRepository.findById(bookTrainDTO.getTrainId()).get();
			if(train!=null) {
			  
				List<PassengerDTO> passengerDTOs= bookTrainDTO.getPassengers();
				List<Passenger> passengers=new ArrayList<>();
				for(PassengerDTO passengerDTO:passengerDTOs) {
					
					Passenger passenger=new Passenger();
					passenger.setPassengerName(passengerDTO.getPassengerName());
					passenger.setAge(passengerDTO.getAge());
					passenger.setUserId(bookTrainDTO.getUserId());
					passengers.add(passenger);
					passengerRespository.save(passenger);
				}
				
				Ticket ticket=new Ticket();
				ticket.setTicketNumber(gen());
				ticket.setSource(bookTrainDTO.getSource());
				ticket.setDestination(bookTrainDTO.getDestination());
				ticket.setDateOfJourney(dateFormatter.parse(bookTrainDTO.getDateOfJourney()));
				ticket.setDateOfBooking(new Date());
				ticket.setTrainId(train.getTrainId());
				ticket.setUserId(bookTrainDTO.getUserId());
				ticket.setPassengers(passengers);
				ticket.setCost(500.0*passengers.size());
			    ticketRepository.save(ticket);
			    
			    
			    
			    //train.setAvailableSeats(train.getAvailableSeats()-passengers.size());
			    //trainRepository.save(train);
			    
			    List<TrainCapacity> trainCapacities=trainCapacityRepository.checkTrainSeatsAvailability(train.getTrainId(), ticket.getDateOfJourney());
			    System.out.println("Train Capacity Size:"+trainCapacities.size());
			    if(trainCapacities.size()==0) {
			    	logger.info("Train Capacity If "+trainCapacities.size());
			    	TrainCapacity trainCapacity=new TrainCapacity();
			    	trainCapacity.setTrainId(train.getTrainId());
			    	trainCapacity.setDate(ticket.getDateOfJourney());
			    	trainCapacity.setAvailableSeats(train.getAvailableSeats()-passengers.size());
			    	trainCapacityRepository.save(trainCapacity);
			    }else {
			    	logger.info("Train Capacity Else "+trainCapacities.size());
			    	TrainCapacity trainCapacity=trainCapacities.get(0);
			    	trainCapacity.setAvailableSeats(trainCapacity.getAvailableSeats()-passengers.size());
			    	trainCapacityRepository.save(trainCapacity);
			    }
				
			    return ticket;
				
			}
			
		}
		
		
		return null;
		
	}
	
	
	public int gen() {
	    Random r = new Random( System.currentTimeMillis() );
	    return 10000 + r.nextInt(20000);
	}

}
