package ola.com.booking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ola.com.booking.ConectionManager;
import ola.com.booking.dao.UserDao;
import ola.com.booking.model.User;

public class UserDaoImpl implements UserDao {

	Connection conn = ConectionManager.getConnection();

	@Override
	public void saveUser(User user) {
		try {
			PreparedStatement stmt = conn
					.prepareStatement("insert into User (userId, email, name, password, phoneNo) values (?,?,?,?,?)");
			stmt.setInt(1, user.getuserId());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getPassword());
			stmt.setString(5, user.getPhoneNo());

			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean validateUser(String username, String password) {
		try {
			PreparedStatement stmt = conn
					.prepareStatement("SELECT EXISTS(SELECT * FROM User WHERE name=? and password=?)");
			stmt.setString(1, username);
			stmt.setString(2, password);

			return stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<User> getUserData(String uname) {
		List<User> userlist = new ArrayList<User>();
		User user = new User();
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM User where name = ? ");
			stmt.setString(1, uname);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("userId"));
				System.out.println("userid" + user.getuserId());
				user.setName(rs.getString("name"));
				user.setPhoneNo(rs.getString("phoneNo"));
				user.setEmail(rs.getString("email"));
				userlist.add(user);
			}
			return userlist;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
