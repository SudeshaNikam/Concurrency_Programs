package ola.com.booking.model;

public class Ride {

	private int rideId;
	private String userId;
	private String routeId;
	private String DateTime;

	public int getRideId() {
		return rideId;
	}

	public void setRideId(int rideId) {
		this.rideId = rideId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getDateTime() {
		return DateTime;
	}

	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Ride [rideId=" + rideId + ", userId=" + userId + ", routeId=" + routeId + ", DateTime=" + DateTime
				+ "]";
	}

}
