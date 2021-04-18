package ola.com.booking.service.impl;

import ola.com.booking.dao.RideDao;
import ola.com.booking.dao.impl.RideDaoImpl;
import ola.com.booking.model.Ride;
import ola.com.booking.service.RideService;

public class RideServiceImpl implements RideService{
	
	RideDao rideDao;

	@Override
	public void BookRide(Ride ride) {
		rideDao = new RideDaoImpl();
		rideDao.bookRide(ride);
		
	}

	@Override
	public Ride getRide() {
		rideDao = new RideDaoImpl();
		Ride ride = rideDao.getRide();
		return ride;
	}

}
