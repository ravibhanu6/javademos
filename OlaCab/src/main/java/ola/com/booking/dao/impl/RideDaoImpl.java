package ola.com.booking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ola.com.booking.ConectionManager;
import ola.com.booking.dao.RideDao;
import ola.com.booking.model.Ride;

public class RideDaoImpl implements RideDao {

	Connection conn = ConectionManager.getConnection();

	@Override
	public void bookRide(Ride ride) {
		try {
			PreparedStatement statement = conn
					.prepareStatement("insert into bookings (userId,routeId,date) " + "values (?,?,?) ");
			statement.setString(1, ride.getUserId());
			statement.setString(2, ride.getRouteId());
			statement.setString(3, ride.getDateTime().toString());

			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Ride getRide() {
		Ride ride = new Ride();
		try {
			ResultSet rs = conn.createStatement().executeQuery("select * from bookings");
			while (rs.next()) {
				ride.setRideId(rs.getInt(1));
				ride.setUserId(rs.getString(2));
				ride.setRouteId(rs.getString(3));
				ride.setDateTime(rs.getDate(4));
			}
			return ride;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
