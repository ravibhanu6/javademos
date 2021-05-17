package com.booktrain.service;

import java.util.List;

import com.booktrain.dto.BookTrainDTO;
import com.booktrain.dto.SearchDTO;
import com.booktrain.model.Ticket;
import com.booktrain.model.Train;

public interface TrainService {

public void loadData();
	
	
	public List<Train> searchTrain(SearchDTO searchDto) throws Exception;
	
	public Ticket bookTrarin(BookTrainDTO bookTrainDTO) throws Exception;
	
	
	public int gen();
}
