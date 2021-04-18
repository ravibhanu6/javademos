package ola.com.booking.dao;

import ola.com.booking.model.Ride;

public interface RideDao {
	
	void bookRide(Ride ride);

	Ride getRide();

}
