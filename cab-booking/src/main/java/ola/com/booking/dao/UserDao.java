package ola.com.booking.dao;

import java.util.List;

import ola.com.booking.model.User;

public interface UserDao {

	void saveUser(User user);
    User validateUser(String username, String password);
	List<User> getUserData();
}
