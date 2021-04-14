package ola.com.booking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

import ola.com.booking.ConectionManager;
import ola.com.booking.dao.RideDao;
import ola.com.booking.model.Ride;

public class RideDaoImpl implements RideDao {

	Connection conn = ConectionManager.getConnection();

	@Override
	public List<Ride> getRides() {
		List<Ride> rideList = new ArrayList<Ride>();
		try {
			ResultSet result = conn.createStatement().executeQuery("select * from ride");
			while (result.next()) {
				Ride ride = new Ride();
				ride.setRideId(result.getInt("rideId"));
				ride.setUserId(result.getString("userId"));
				ride.setRouteId(result.getString("routeId"));
				ride.setDateTime(result.getString("DateTime"));
				rideList.add(ride);

			}
			return rideList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveRide(Ride ride) {
		try {
			LocalDate localDate = LocalDate.now();
			String rideDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(localDate);

			LocalTime localTime = LocalTime.now();
			String ridetime = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(localTime);

			PreparedStatement stmt = conn
					.prepareStatement("insert into Ride (rideId, userId, routeId, DateTime) values (?,?,?,?)");
			stmt.setInt(1, ride.getRideId());
			stmt.setString(2, ride.getUserId());
			stmt.setString(3, ride.getRouteId());
			stmt.setString(4, rideDate + " " + ridetime);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
