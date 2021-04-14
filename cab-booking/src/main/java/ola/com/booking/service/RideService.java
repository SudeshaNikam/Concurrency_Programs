package ola.com.booking.service;

import java.util.List;

import ola.com.booking.model.Ride;

public interface RideService {

	// create a class containing all ride class members + userId
	public List<Ride> getRides();

	public void saveRide(Ride ride);
}
