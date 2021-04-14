package ola.com.booking.dao;

import java.util.List;

import ola.com.booking.model.Ride;

public interface RideDao {

	public List<Ride> getRides();

	public void saveRide(Ride ride);

}
